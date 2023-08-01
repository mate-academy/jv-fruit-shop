package model;

public class InvalidTransaction extends RuntimeException {
    public InvalidTransaction(String text) {
        super(text);
    }
}
