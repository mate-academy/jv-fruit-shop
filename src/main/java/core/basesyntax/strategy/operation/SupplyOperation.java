package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        Storage.fruitStorage.merge(fruit.getName(), fruit.getQuantity(), Integer::sum);
    }
}
