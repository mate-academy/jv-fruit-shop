package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Integer quantityToAdd = transaction.getQuantity();
        Integer currentQuantity = FruitStorage.storage.getOrDefault(fruit, 0);
        FruitStorage.storage.put(fruit, currentQuantity + quantityToAdd);
    }
}
