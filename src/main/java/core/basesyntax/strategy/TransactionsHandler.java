package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.ITransactionsHandler;

public class TransactionsHandler<FruitTransaction> implements ITransactionsHandler<FruitTransaction> {
    public boolean handle(FruitTransaction fruitTransaction) {
        return false;
    }
}
