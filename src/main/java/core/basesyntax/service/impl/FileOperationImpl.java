package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class FileOperationImpl implements OperationStrategy {
    private static final String CSV_SEPARATOR = ",";
    private Map<String, FruitOperationHandler> mapStrategy;
    private StorageService storageService = new StorageServiceImpl();

    public FileOperationImpl(Map<String, FruitOperationHandler> mapStrategy) {
        this.mapStrategy = mapStrategy;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fruit, Quantity\n");
        for (Map.Entry<Fruit,Integer> entry : storageService.getAllData().entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
