package core.basesyntax.operations;

import core.basesyntax.storage.StorageInformation;
import core.basesyntax.service.FruitTransaction;

public class BalanceOperationAction implements OperationAction{
    @Override
    public void makeShopOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer fruitQuantity = fruitTransaction.getQuantity();
        StorageInformation.shopReport.put(fruit, fruitQuantity);
    }
}
