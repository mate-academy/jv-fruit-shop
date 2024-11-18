package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(List<FruitTransaction> transactions, Map<String, Integer> inventory) {
        for (FruitTransaction transaction : transactions) {
            if (transaction.getOperation() == FruitTransaction.Operation.PURCHASE) {
                inventory.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
            }
        }
    }
}
