package core.basesyntax.operations;

import core.basesyntax.storage.StorageInformation;
import core.basesyntax.service.FruitTransaction;

public class ReturningOperationAction implements OperationAction {
    public void makeShopOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer supplingValue = fruitTransaction.getQuantity();

        if (StorageInformation.shopReport.containsKey(fruit)) {
            supplingValue = StorageInformation.shopReport.get(fruit) + supplingValue;
        }
        StorageInformation.shopReport.put(fruit, supplingValue);
    }
}
