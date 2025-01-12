package core.basesyntax.operationhandlers;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    private Storage storage = new Storage();

    @Override
    public int apply(String fruitType, int amount) {
        Map<String, Integer> storage1 = storage.getStorage();
        storage1.put(fruitType, amount);
        return amount;
    }
}
