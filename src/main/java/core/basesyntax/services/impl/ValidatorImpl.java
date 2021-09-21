package core.basesyntax.services.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.services.Validator;
import java.util.NoSuchElementException;

public class ValidatorImpl implements Validator {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int SIZE_TRANSLATION = 3;
    private static final int ZERO = 0;

    @Override
    public boolean checkInputData(String[] data) {
        findOperation(data[OPERATION]);
        if (data.length != SIZE_TRANSLATION
                || data[FRUIT_NAME].isBlank()
                || Integer.parseInt(data[QUANTITY]) < 0
                || data[OPERATION].length() != 1) {
            throw new RuntimeException("Incorrect input data");
        }
        return true;
    }

    @Override
    public Transaction.Operation findOperation(String operation) {
        switch (operation) {
            case "b": return Transaction.Operation.BALANCE;
            case "s": return Transaction.Operation.SUPPLY;
            case "p": return Transaction.Operation.PURCHASE;
            case "r": return Transaction.Operation.RETURN;
            default: throw new NoSuchElementException("Incorrect operation");
        }
    }

    @Override
    public boolean checkOperation(int money) {
        if (money < ZERO) {
            throw new RuntimeException("Incorrect input data");
        }
        return true;
    }
}
