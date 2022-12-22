package core.basesyntax.operations;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class PurchasingTransactionExecutor implements TransactionExecutor {
    private Map<String, Integer> fruitMap = Storage.FRUIT_MAP;

    @Override
    public void execute(core.basesyntax.service.FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer purchaseQuantity = fruitTransaction.getQuantity();

        if (fruitMap.containsKey(fruit)
                && fruitMap.get(fruit) > purchaseQuantity) {
            Integer purchaseResult = fruitMap.get(fruit)
                    - purchaseQuantity;
            fruitMap.put(fruit, purchaseResult);
        }
    }
}
