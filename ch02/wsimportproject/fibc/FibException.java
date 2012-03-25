package fibc;

public class FibException extends Exception {
    private String details;

    public FibException(String reason, String details) {
        super(reason);
        this.details = details;
    }

    public String getFaultInfo() {
        return details;
    }
}