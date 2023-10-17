package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;

import java.util.Optional;
import java.util.SplittableRandom;

public class PurchaseActivityStrategyImpl implements TypeActivityStrategy {
    @Override
    public void setNewAmount(Integer amount, FruitTransaction fruitTransaction) {
        for (FruitTransaction fruit : Storage.fruitTransactions) {
            if (fruit.getFruit().equals(fruitTransaction.getFruit())) {
                fruit.setQuantity(fruit.getQuantity() - amount);
            }
        }
    }
    }

