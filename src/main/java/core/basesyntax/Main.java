package core.basesyntax;

import core.basesyntax.filework.CsvFileReaderImpl;
import core.basesyntax.filework.CsvFileWriterImpl;
import core.basesyntax.model.Type;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.strategy.DecreaseOperationHandler;
import core.basesyntax.service.strategy.IncreaseOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Type, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Type.BALANCE, new IncreaseOperationHandler());
        operationHandlerMap.put(Type.SUPPLY, new IncreaseOperationHandler());
        operationHandlerMap.put(Type.RETURN, new IncreaseOperationHandler());
        operationHandlerMap.put(Type.PURCHASE, new DecreaseOperationHandler());

        FruitService fruitService = new FruitServiceImpl(new CsvFileReaderImpl(),
                new CsvFileWriterImpl());
        fruitService.createReport(operationHandlerMap);
    }
}
