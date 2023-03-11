package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ResultGeneratorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ResultGeneratorServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/inputData.csv";
    private static final String OUTPUT_PATH = "src/main/resources/outputData.csv";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> readData = readerService.read(INPUT_PATH);
        new ValidatorImpl().validate(readData);
        readData.remove(readData.get(0));

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        operationHandlerMap.put("b", new BalanceOperationHandler(fruitStorageDao));
        operationHandlerMap.put("s", new SupplyOperationHandler(fruitStorageDao));
        operationHandlerMap.put("r", new ReturnOperationHandler(fruitStorageDao));
        operationHandlerMap.put("p", new PurchaseOperationHandler(fruitStorageDao));

        for (String line: readData) {
            String[] splittedLine = line.split(",");
            String operation = splittedLine[INDEX_OF_OPERATION];
            OperationHandler operationsHandler = operationHandlerMap.get(operation);
            operationsHandler.handleOperation(splittedLine[INDEX_OF_FRUIT],
                    Integer.parseInt(splittedLine[INDEX_OF_QUANTITY]));
        }
        ResultGeneratorService resultGeneratorService
                = new ResultGeneratorServiceImpl(fruitStorageDao);
        String result = resultGeneratorService.generateResult();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(OUTPUT_PATH, result);
    }
}
