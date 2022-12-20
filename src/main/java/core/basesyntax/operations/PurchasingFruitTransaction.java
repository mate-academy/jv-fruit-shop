package core.basesyntax.operations;

import core.basesyntax.storage.StorageInformation;

public class PurchasingFruitTransaction implements FruitTransaction {
    @Override
    public void execute(core.basesyntax.service.FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer purchaseQuantity = fruitTransaction.getQuantity();

        if (StorageInformation.getShopReport().containsKey(fruit)
                && StorageInformation.getShopReport().get(fruit) > purchaseQuantity) {
            Integer purchaseResult = StorageInformation.getShopReport().get(fruit)
                    - purchaseQuantity;
            StorageInformation.getShopReport().put(fruit, purchaseResult);
        }
    }
}
