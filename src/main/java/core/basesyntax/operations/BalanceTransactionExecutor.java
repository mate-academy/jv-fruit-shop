package core.basesyntax.operations;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class BalanceTransactionExecutor implements TransactionExecutor {
    private Map<String, Integer> fruitMap = Storage.FRUIT_MAP;

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer fruitQuantity = fruitTransaction.getQuantity();
        fruitMap.put(fruit, fruitQuantity);
    }
}
