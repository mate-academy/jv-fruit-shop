package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.strategy.FruitAmountCalculateStrategy;
import core.basesyntax.strategy.OperationStrategyHolder;

import java.util.List;

public class FruitTransactionsHandlerImpl implements FruitTransactionHandler {
    private final FruitStorage fruitStorage;

    public FruitTransactionsHandlerImpl(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void processTransactionsList(List<FruitTransaction> fruitTransactionList) {
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            FruitTransaction fruitTransaction = fruitTransactionList.get(i);
            FruitAmountCalculateStrategy strategy = OperationStrategyHolder.getStrategy(fruitTransaction.getOperation());
            fruitStorage.updateFruitQuantity(fruitTransaction.getFruit(), strategy.getFruitAmount(fruitTransaction.getQuantity()));
        }


    }
}
