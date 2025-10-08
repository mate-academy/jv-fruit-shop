package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    public void handle(FruitTransaction transaction, Map<String, Integer> stock) {
        stock.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}
