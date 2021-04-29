package core.basesyntax.service;

import core.basesyntax.filework.FileReader;
import core.basesyntax.filework.FileWriter;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public interface FruitService {
    void createReport(FileReader reader, FileWriter writer,
                      Map<OperationType, OperationHandler> operationHandlerMap);
}
