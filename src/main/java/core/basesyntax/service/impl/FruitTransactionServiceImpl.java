package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AmountService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.AmountStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TYPE_OF_TRANSACTION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String DELIMITER = ",";
    AmountStrategy amountStrategy;

    public FruitTransactionServiceImpl() {
        amountStrategy = new AmountStrategy();
    }

    @Override
    public FruitTransaction processTransactionFromLine(String string) {
        String[] elements = string.split(DELIMITER);
        return new FruitTransaction(elements[TYPE_OF_TRANSACTION], elements[TYPE_OF_FRUIT],
                getAmount(elements[TYPE_OF_TRANSACTION], elements[AMOUNT]));
    }

    private int getAmount(String type, String amount) {
        AmountService amountService = amountStrategy.getAmountService(type);
        return amountService.getAmount(Integer.parseInt(amount));
    }
}
