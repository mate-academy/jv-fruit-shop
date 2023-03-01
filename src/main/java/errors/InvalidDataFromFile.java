package errors;

public class InvalidDataFromFile extends RuntimeException {
    public InvalidDataFromFile(String message) {
        super(message);
    }
}
