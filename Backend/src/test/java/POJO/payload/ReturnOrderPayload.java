package POJO.payload;

public class ReturnOrderPayload {
    private String reason;

    public ReturnOrderPayload(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
