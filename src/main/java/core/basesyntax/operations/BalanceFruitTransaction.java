package core.basesyntax.operations;

import core.basesyntax.storage.StorageInformation;

public class BalanceFruitTransaction implements FruitTransaction {
    @Override
    public void execute(core.basesyntax.service.FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer fruitQuantity = fruitTransaction.getQuantity();
        StorageInformation.putShopReport(fruit, fruitQuantity);
    }
}
