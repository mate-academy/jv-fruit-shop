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
        String[] elements = string.split(DELIMITER);
        return new FruitTransaction(elements[TYPE_OF_TRANSACTION], elements[TYPE_OF_FRUIT],
                getAmount(elements[TYPE_OF_TRANSACTION], elements[AMOUNT]));
    }

    private int getAmount(String type, String amount) {
        AmountStrategy amountStrategy = new AmountStrategy();
        AmountService amountService = amountStrategy.getAmountService(type);
        return amountService.getAmount(Integer.parseInt(amount));
    }
}
