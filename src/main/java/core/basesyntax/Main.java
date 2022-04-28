package core.basesyntax;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.Map;
import operation.BalanceOperationHandler;
import operation.OperationHandler;
import operation.PurchaseOperationHandler;
import operation.ReturnOperationHandler;
import operation.SupplyOperationHandler;
import service.FileReader;
import service.FileWriter;
import service.FruitService;
import service.FruitTransactionService;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.FruitServiceImpl;
import service.impl.FruitTransactionServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String OUTPUT_PATH = "src/main/java/resources/output.csv";
    private static final String INPUT_PATH = "src/main/java/resources/input.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler(storageDao));
        operationHandlerMap.put("p", new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put("r", new ReturnOperationHandler(storageDao));
        operationHandlerMap.put("s", new SupplyOperationHandler(storageDao));

        FileReader fileReader = new FileReaderImpl();
        FruitService fruitService = new FruitServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(fruitService, operationStrategy);
        fruitTransactionService.transfer(fileReader.read(INPUT_PATH));
        FileWriter fileWriter = new FileWriterImpl(storageDao);
        fileWriter.write(OUTPUT_PATH);
    }
}
