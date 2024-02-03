package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        String getFruitFromStorage = fruit.getName();
        Integer quantityBefore = Storage.fruitStorage.get(getFruitFromStorage);

        validateTransaction(fruit, quantityBefore);

        Integer quantityAfter = quantityBefore - fruit.getQuantity();
        Storage.fruitStorage.put(getFruitFromStorage, quantityAfter);
    }

    private void validateTransaction(FruitTransaction fruit, Integer quantityBefore) {
        if (quantityBefore == null) {
            throw new RuntimeException(fruit.getName()
                    + "completed.");
        }
        if (quantityBefore < fruit.getQuantity()) {
            throw new RuntimeException("We have run out of"
                    + fruit.getName() + ". Only"
                    + quantityBefore + "amount is left.");
        }
    }
}
