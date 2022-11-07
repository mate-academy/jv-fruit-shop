package core.basesyntax.service;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public interface FruitService {
    String readData(String filePath);

    String processFruitsData(
            Map<String, OperationHandler> operationServiceMap,
             String data, DataTransactionParser dataTransactionParser);

    void createResultFile(String report, String filePath);
}
