package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
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
                || findOperation(data[OPERATION]).toString().length() != 1) {
            throw new RuntimeException("Incorrect input data ");
        }
        return true;
    }

    public static Transaction.Operation findOperation(String data) {
        switch (data) {
            case "b" : return Transaction.Operation.BALANCE;
            case "s" : return Transaction.Operation.SUPPLY;
            case "p" : return Transaction.Operation.PURCHASE;
            case "r" : return Transaction.Operation.RETURN;
            default: throw new NoSuchElementException("Incorrect operation");
        }
    }
}
