package core.basesyntax.operations;

import core.basesyntax.storage.StorageInformation;
import core.basesyntax.service.FruitTransaction;

public class PurchasingOperationAction implements OperationAction {

    @Override
    public void makeShopOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer purchaseQuantity = fruitTransaction.getQuantity();

        if(StorageInformation.shopReport.containsKey(fruit) && StorageInformation.shopReport.get(fruit) > purchaseQuantity) {
            Integer purchaseResult = StorageInformation.shopReport.get(fruit) - purchaseQuantity;
            StorageInformation.shopReport.put(fruit, purchaseResult);
        }
    }
}
