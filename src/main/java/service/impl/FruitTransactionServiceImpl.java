package service.impl;

import model.FruitTransaction;
import service.AmountService;
import service.FruitTransactionService;
import strategy.AmountStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TYPE_OF_TRANSACTION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String DELIMITER = ",";

    @Override
    public FruitTransaction createFruitTransaction(String string) {
        return new FruitTransaction(getType(string), getFruit(string), getAmount(string));
    }

    private String getType(String string) {
        return string.split(DELIMITER)[TYPE_OF_TRANSACTION];
    }

    private String getFruit(String string) {
        return string.split(DELIMITER)[TYPE_OF_FRUIT];
    }

    private int getAmount(String string) {
        AmountStrategy amountStrategy = new AmountStrategy();
        AmountService amountService = amountStrategy.getAmountService(getType(string));
        return amountService.getAmount(Integer.parseInt(string.split(DELIMITER)[AMOUNT]));
    }
}
