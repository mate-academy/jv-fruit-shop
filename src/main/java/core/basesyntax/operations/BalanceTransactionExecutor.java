package core.basesyntax.operations;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.storageq.StorageInformation;

public class BalanceTransactionExecutor implements TransactionExecutor {
    @Override
    public void execute(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer fruitQuantity = fruitTransaction.getQuantity();
        StorageInformation.putShopReport(fruit, fruitQuantity);
    }
}
