package service.impl;

import model.FruitTransaction;
import service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TYPE_OF_TRANSACTION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String NEGATIVE_TRANSACTION = "p";
    private static final String DELIMITER = ",";

    @Override
    public FruitTransaction createFruitTransaction(String string) {
        return new FruitTransaction(getType(string), getFruit(string), getAmount(string));
    }

    @Override
    public FruitTransaction createFruitTransaction(String type, String fruit, int quantity) {
        if (type.equals(NEGATIVE_TRANSACTION) && quantity > 0) {
            quantity *= -1;
        }
        return new FruitTransaction(type, fruit, quantity);
    }

    private String getType(String string) {
        return string.split(DELIMITER)[TYPE_OF_TRANSACTION];
    }

    private String getFruit(String string) {
        return string.split(DELIMITER)[TYPE_OF_FRUIT];
    }

    private int getAmount(String string) {
        int amount = Integer.parseInt(string.split(DELIMITER)[AMOUNT]);
        if (getType(string).equals(NEGATIVE_TRANSACTION) && amount > 0) {
            return amount * -1;
        }
        return amount;
    }

}
