package core.basesyntax.operationhandlers;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    private Storage storage = new Storage();

    @Override
    public int apply(String fruitType, int amount) {
        Map<String, Integer> storage1 = storage.getStorage();
        int returnedAmount = storage1.getOrDefault(fruitType, 0) + amount;
        storage1.put(fruitType, returnedAmount);
        return returnedAmount;
    }
}
