package core.basesyntax.operations;

import core.basesyntax.storageq.StorageInformation;

public class ReturningTransactionExecutor implements TransactionExecutor {
    public void execute(core.basesyntax.service.FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer supplingValue = fruitTransaction.getQuantity();

        if (StorageInformation.getShopReport().containsKey(fruit)) {
            supplingValue = StorageInformation.getShopReport().get(fruit) + supplingValue;
        }
        StorageInformation.getShopReport().put(fruit, supplingValue);
    }
}
