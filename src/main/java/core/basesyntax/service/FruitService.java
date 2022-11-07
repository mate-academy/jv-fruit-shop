package core.basesyntax.service;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public interface FileService {
    String readData();

    String processFruitsData(Map<String, OperationHandler> operationServiceMap, String data, DataTransactionParser dataTransactionParser);

    void createResultFile(String report);
}
