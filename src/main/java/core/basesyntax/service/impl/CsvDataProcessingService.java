package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataConvertingToObjectsService;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;

public class CsvDataProcessingService implements DataProcessingService {
    private OperationStrategy operationStrategy;
    private DataConvertingToObjectsService dataConvertingToObjects;

    public CsvDataProcessingService(OperationStrategy operationStrategy,
                                    DataConvertingToObjectsService dataConvertingToObjects) {
        this.operationStrategy = operationStrategy;
        this.dataConvertingToObjects = dataConvertingToObjects;
    }

    @Override
    public void importDataToStorage() {
        for (Fruit fruit : dataConvertingToObjects.convertDataToObjects()) {
            OperationHandler operationHandler = operationStrategy.get(fruit.getOperation());
            Fruit processedFruit = operationHandler.completeOperation(fruit);
            Storage.storage.put(processedFruit.getName(), processedFruit.getQuantity());
        }
    }
}
