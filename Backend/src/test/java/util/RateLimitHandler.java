package util;

import io.restassured.response.Response;

public class RateLimitHandler {
    private static final int MAX_RETRIES = 3;
    private static final int INITIAL_DELAY_MS = 1000;
    private static final int BACKOFF_MULTIPLIER = 2;
    private static final long REQUEST_DELAY_MS = 500;

    public static Response executeWithRetry(RequestExecutor requestExecutor) {
        Response response = null;
        int attempt = 0;
        int delayMs = INITIAL_DELAY_MS;

        while (attempt <= MAX_RETRIES) {
            try {
                response = requestExecutor.execute();

                if (response.statusCode() != 429) {
                    return response;
                }
                if (attempt < MAX_RETRIES) {
                    long retryAfter = parseRetryAfterHeader(response);
                    delayMs = (int) Math.max(delayMs, retryAfter);

                    System.out.println(String.format(
                            "[Attempt %d/%d] Rate limited (429). Waiting %dms before retry",
                            attempt + 1, MAX_RETRIES, delayMs
                    ));

                    Thread.sleep(delayMs);
                    delayMs *= BACKOFF_MULTIPLIER;
                    attempt++;
                } else {
                    return response;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Request interrupted", e);
            }
        }

        return response;
    }
    public static void delayBetweenRequests() {
        try {
            Thread.sleep(REQUEST_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private static long parseRetryAfterHeader(Response response) {
        try {
            String retryAfter = response.getHeader("Retry-After");
            if (retryAfter != null) {
                return Long.parseLong(retryAfter) * 1000;
            }
        } catch (NumberFormatException ignored) {
        }
        return INITIAL_DELAY_MS;
    }
    @FunctionalInterface
    public interface RequestExecutor {
        Response execute();
    }
}
