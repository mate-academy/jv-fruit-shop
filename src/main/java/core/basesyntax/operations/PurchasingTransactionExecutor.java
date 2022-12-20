package core.basesyntax.operations;

import core.basesyntax.storageq.StorageInformation;

public class PurchasingTransactionExecutor implements TransactionExecutor {
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
