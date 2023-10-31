package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationStrategy implements OperationStrategy {
    @Override
    public void process(FruitTransaction transaction, FruitStorage storage) {
        storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
