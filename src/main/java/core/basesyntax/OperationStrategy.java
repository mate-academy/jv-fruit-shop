package core.basesyntax;

import core.basesyntax.fruitstoreoperation.FruitStoreOperation;
import java.util.Map;

public class OperationStrategy {
    private Map<String, FruitStoreOperation> fruitStoreOperationMap;

    public OperationStrategy(Map<String, FruitStoreOperation> fruitStoreOperationMap) {
        this.fruitStoreOperationMap = fruitStoreOperationMap;
    }

    public FruitStoreOperation choseOperation(String type) {
        return fruitStoreOperationMap.get(type);
    }
}
