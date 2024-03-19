package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationStrategy {

    public void processData(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction is null");
        }
        String product = fruitTransaction.product();
        int amount = fruitTransaction.amount();
        switch (fruitTransaction.operation()) {
            case BALANCE:
                Storage.DATA.put(product, amount);
                break;
            case PURCHASE:
                Storage.DATA.put(product, Storage.DATA.getOrDefault(product, 0) - amount);
                break;
            case RETURN, SUPPLY:
                Storage.DATA.put(product, Storage.DATA.getOrDefault(product, 0) + amount);
                break;
            default:
                throw new IllegalArgumentException("Unknown fruitTransaction operation type");
        }
    }
}
