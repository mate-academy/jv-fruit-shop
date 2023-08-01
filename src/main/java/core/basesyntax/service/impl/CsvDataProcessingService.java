package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;

public class CsvDataProcessingService implements DataProcessingService {
    private OperationStrategy operationStrategy;
    private DataConverterService dataConvertingToObjects;

    public CsvDataProcessingService(OperationStrategy operationStrategy,
                                    DataConverterService dataConvertingToObjects) {
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
