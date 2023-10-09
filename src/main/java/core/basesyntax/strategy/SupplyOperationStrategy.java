package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class SupplyOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitStorage.fruitStorage.merge(fruitTransaction.getName(),
                fruitTransaction.getAmount(), Integer::sum);
    }
}
