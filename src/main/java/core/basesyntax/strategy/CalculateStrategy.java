package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class CalculateStrategy {
    private int value = 0;

    public void setOperation(FruitTransaction fruitTransaction,
                              FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE:
                Storage.result.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
                break;
            case SUPPLY:
            case RETURN:
                value = Storage.result.get(fruitTransaction.getFruit());
                Storage.result.put(fruitTransaction.getFruit(), value
                        + fruitTransaction.getQuantity());
                break;
            case PURCHASE:
                value = Storage.result.get(fruitTransaction.getFruit());
                Storage.result.put(fruitTransaction.getFruit(),
                        value - fruitTransaction.getQuantity());
                break;
            default:
                break;
        }

    }
}
