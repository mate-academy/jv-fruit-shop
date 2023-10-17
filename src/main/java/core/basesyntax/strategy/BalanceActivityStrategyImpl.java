package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class BalanceActivityStrategyImpl implements TypeActivityStrategy {

    @Override
    public void setNewAmount(Integer amount, FruitTransaction fruitTransaction) {
            Storage.fruitTransactions.add(fruitTransaction);
            fruitTransaction.setQuantity(amount);
    }
}
