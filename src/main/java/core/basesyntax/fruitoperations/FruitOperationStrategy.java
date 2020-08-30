package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;
import java.util.HashMap;
import java.util.Map;

public class FruitOperationStrategy {
    private Storage storage;
    private Map<String, FruitOperation> operationHashMap = new HashMap<>();

    public FruitOperationStrategy(Storage storage) {
        this.storage = storage;
        initHashMap();
    }

    private void initHashMap() {
        operationHashMap.put("b", new BuyFruitOperation(storage));
        operationHashMap.put("r", new ReturnFruitOperation(storage));
        operationHashMap.put("s", new SupplyFruitOperation(storage));
    }

    public void applyOperationOnBatch(FruitBatch fruitBatch) {
        if (!operationHashMap.containsKey(fruitBatch.getOperation())) {
            throw new IllegalArgumentException("No such operation " + fruitBatch.getOperation());

        }
        operationHashMap.get(fruitBatch.getOperation()).apply(fruitBatch);
    }
}
