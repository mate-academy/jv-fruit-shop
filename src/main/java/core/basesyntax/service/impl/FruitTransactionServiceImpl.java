package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.AmountService;
import core.basesyntax.strategy.AmountStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TYPE_OF_TRANSACTION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;
    private AmountStrategy amountStrategy;

    public FruitTransactionServiceImpl() {
        amountStrategy = new AmountStrategy();
    }

    @Override
    public FruitTransaction createTransaction(String[] transactionData) {
        return new FruitTransaction(transactionData[TYPE_OF_TRANSACTION],
                transactionData[TYPE_OF_FRUIT], getAmount(transactionData[TYPE_OF_TRANSACTION],
                transactionData[AMOUNT]));
    }

    private int getAmount(String type, String amount) {
        AmountService amountService = amountStrategy.getAmountService(type);
        return amountService.getAmount(Integer.parseInt(amount));
    }
}
