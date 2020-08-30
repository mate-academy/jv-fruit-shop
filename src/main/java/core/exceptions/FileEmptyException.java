package core.exceptions;

public class FileEmptyException extends RuntimeException {
    public FileEmptyException(String massages) {
        super(massages);
    }
}
