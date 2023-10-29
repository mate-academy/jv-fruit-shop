package core.basesyntax.service;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.OperationType;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class DataHandlerImpl implements DataHandler {
    private final Map<OperationType, OperationHandler> operation;

    public DataHandlerImpl(Map<OperationType, OperationHandler> operation) {
        this.operation = operation;
    }

    public void handler(List<FruitTransaction> fruitDataList) {
        for (FruitTransaction fruit: fruitDataList) {
            OperationHandler operationHandler = operation.get(fruit.getOperationType());
            operationHandler.dataHandler(fruit);
        }
    }
}
