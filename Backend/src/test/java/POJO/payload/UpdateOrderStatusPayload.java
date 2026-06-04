package POJO.payload;

public class UpdateOrderStatusPayload {
    private String status;
    private String message;
    private String trackingNumber;

    public UpdateOrderStatusPayload(
            String status,
            String message,
            String trackingNumber) {

        this.status = status;
        this.message = message;
        this.trackingNumber = trackingNumber;
    }

    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}
