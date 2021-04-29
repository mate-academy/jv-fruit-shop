package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.filework.FileReader;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public void createReport(Map<OperationType, OperationHandler> operationHandlerMap,
                             FileReader fileReader) {
        for (FruitRecordDto fruit : fileReader.getStorage()) {
            operationHandlerMap.get(fruit.getType())
                    .apply(fruit);
        }
    }
}
