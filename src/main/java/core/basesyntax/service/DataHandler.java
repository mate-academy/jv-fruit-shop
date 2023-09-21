package core.basesyntax.service;

import core.basesyntax.data.FruitData;
import core.basesyntax.data.OperationType;
import core.basesyntax.impl.OperationHandler;
import java.util.List;
import java.util.Map;

public class DataHandler {
    private final Map<OperationType, OperationHandler> operation;

    public DataHandler(Map<OperationType, OperationHandler> operation) {
        this.operation = operation;
    }

    public void handler(List<FruitData> fruitDataList) {
        for (FruitData fruit: fruitDataList) {
            OperationHandler operationHandler = operation.get(fruit.getOperationType());
            operationHandler.dataHandler(fruit);
        }
    }
}
