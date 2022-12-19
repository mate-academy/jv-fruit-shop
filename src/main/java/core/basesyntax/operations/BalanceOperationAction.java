package core.basesyntax.operations;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.storage.StorageInformation;

public class BalanceOperationAction implements OperationAction {
    @Override
    public void makeShopOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer fruitQuantity = fruitTransaction.getQuantity();
        StorageInformation.putShopReport(fruit, fruitQuantity);
    }
}
