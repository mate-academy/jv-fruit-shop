package core.basesyntax.service;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public interface FileService {

    Map<String, OperationHandler> prepareAndGetOperationData();

    String readData();

    String processFruitsData(Map<String, OperationHandler> operationServiceMap, String data);

    void createResultFile(String report);
}
