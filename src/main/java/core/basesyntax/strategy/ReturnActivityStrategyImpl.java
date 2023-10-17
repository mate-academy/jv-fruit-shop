package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class ReturnActivityStrategyImpl implements TypeActivityStrategy {
    @Override
    public void setNewAmount(Integer amount, FruitTransaction fruitTransaction) {
        for (FruitTransaction fruit : Storage.fruitTransactions) {
            if (fruit.getFruit().equals(fruitTransaction.getFruit())) {
                fruit.setQuantity(fruit.getQuantity() + amount);
            }
        }
    }
}
