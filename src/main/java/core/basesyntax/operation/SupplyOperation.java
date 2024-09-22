package core.basesyntax.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        FruitStorage.fruitRepository.merge(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(), Integer::sum);
    }
}
