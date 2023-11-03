package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import java.util.Map;

public class PurchaseDataHandler implements DataHandler {
    @Override
    public void processWithData(FruitTransaction transaction, Map<String, Integer> data) {
        String fruit = transaction.getFruit();
        int quantityBefore = data.get(transaction.getFruit());
        int quantityTransaction = transaction.getQuantity();
        int quantityAfter = quantityBefore - quantityTransaction;
        if (quantityBefore > quantityTransaction) {
            data.put(fruit, quantityAfter);
        }
    }
}
