package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> stock) {
        stock.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);

    }
}
