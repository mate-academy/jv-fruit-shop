package core.basesyntax.service;

import java.util.NoSuchElementException;

public class ValidatorImpl implements Validator {
    public static final int OPERATION = 0;
    public static final int FRUIT_NAME = 1;
    public static final int QUALITY = 2;
    public static final int SIZE_TRANSLATION = 3;
    public static final int ZERO = 0;

    public boolean checkOperation(int money) {
        if (money < ZERO) {
            throw new RuntimeException("Incorrect input data");
        }
        return true;
    }

    public boolean checkInputData(String[] data) {
        if (data.length != SIZE_TRANSLATION
                || (data[FRUIT_NAME].isBlank()
                || data[FRUIT_NAME].isEmpty())
                || Integer.parseInt(data[QUALITY]) < 0
                || findOperation(data[OPERATION]).length() != 1) {
            throw new RuntimeException("Incorrect input data ");
        }
        return true;
    }

    public String findOperation(String data) {
        switch (data) {
            case "b" : return Operations.BALANCE.toString().toLowerCase();
            case "s" : return Operations.SUPPLY.toString().toLowerCase();
            case "p" : return Operations.PURCHASE.toString().toLowerCase();
            case "r" : return Operations.RETURN.toString().toLowerCase();
            default: throw new NoSuchElementException("Incorrect operation");
        }
    }

    public enum Operations {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN
    }
}
