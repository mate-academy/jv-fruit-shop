package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.AmountService;
import core.basesyntax.strategy.AmountStrategy;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TYPE_OF_TRANSACTION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;
    private AmountStrategy amountStrategy;

    public FruitTransactionServiceImpl() {
        amountStrategy = new AmountStrategy();
    }

    @Override
    public List<FruitTransaction> createTransactions(List<String[]> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String[] onePieceOfData : data) {
            transactions.add(new FruitTransaction(onePieceOfData[TYPE_OF_TRANSACTION],
                    onePieceOfData[TYPE_OF_FRUIT], getAmount(onePieceOfData[TYPE_OF_TRANSACTION],
                    onePieceOfData[AMOUNT])));
        }
        return transactions;
    }

    private int getAmount(String type, String amount) {
        AmountService amountService = amountStrategy.getAmountService(type);
        return amountService.getAmount(Integer.parseInt(amount));
    }
}
