package core.basesyntax.operations;

import core.basesyntax.storage.StorageInformation;

public class SupplingFruitTransaction implements FruitTransaction {
    @Override
    public void execute(core.basesyntax.service.FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer supplingValue = fruitTransaction.getQuantity();

        if (StorageInformation.getShopReport().containsKey(fruit)) {
            supplingValue = StorageInformation.getShopReport().get(fruit) + supplingValue;
        }
        StorageInformation.putShopReport(fruit, supplingValue);
    }
}
