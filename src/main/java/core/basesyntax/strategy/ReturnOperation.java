package core.basesyntax.strategy;

import java.util.Map;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Map<String, Integer> storage = Storage.getStorage();
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0)
                        + transaction.getQuantity());
    }
}
