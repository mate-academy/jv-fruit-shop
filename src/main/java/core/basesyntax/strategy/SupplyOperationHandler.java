package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Map<Fruit, Integer> fruitsMap = Storage.getFruitsMap();
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = fruitsMap.get(fruit);
        fruitsMap.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
