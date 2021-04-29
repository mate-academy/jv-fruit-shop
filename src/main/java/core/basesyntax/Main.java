package core.basesyntax;

import core.basesyntax.filework.CsvFileReaderImpl;
import core.basesyntax.filework.CsvFileWriterImpl;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.strategy.DecreaseOperationHandler;
import core.basesyntax.service.strategy.IncreaseOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new IncreaseOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new IncreaseOperationHandler());
        operationHandlerMap.put(OperationType.RETURN, new IncreaseOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new DecreaseOperationHandler());

        FruitService fruitService = new FruitServiceImpl();
        fruitService.createReport(new CsvFileReaderImpl(),
                new CsvFileWriterImpl(), operationHandlerMap);
    }
}
