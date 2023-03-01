package errors;

public class ErrorWritingDataToFile extends RuntimeException {
    public ErrorWritingDataToFile(String message) {
        super(message);
    }
}
