package core.basesyntax.operations;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.storage.StorageInformation;

public class ReturningOperationAction implements OperationAction {
    public void makeShopOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer supplingValue = fruitTransaction.getQuantity();

        if (StorageInformation.getShopReport().containsKey(fruit)) {
            supplingValue = StorageInformation.getShopReport().get(fruit) + supplingValue;
        }
        StorageInformation.getShopReport().put(fruit, supplingValue);
    }
}
