package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.filework.CsvFileReaderImpl;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public void createReport(Map<OperationType, OperationHandler> operationHandlerMap) {
        for (FruitRecordDto fruit : CsvFileReaderImpl.fruitStore) {
            operationHandlerMap.get(fruit.getType())
                    .apply(fruit);
        }
    }
}
