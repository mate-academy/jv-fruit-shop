package core.basesyntax.service;

public class Validator {
    public static final int DEFAULT_CAPACITY = 3;
    public static final int AMOUNT = 2;

    public void validate(String[] data) {
        if (data.length < DEFAULT_CAPACITY || Integer.parseInt(data[AMOUNT]) < 0) {
            throw new RuntimeException("Wrong input data");
        }
    }
}
