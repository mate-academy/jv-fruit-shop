package core.basesyntax;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.operations.BalanceOperationHandlerImpl;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperationHandlerImpl;
import core.basesyntax.operations.ReturnOperationHandlerImpl;
import core.basesyntax.operations.SupplyOperationHandlerImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation.Type, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.Type.BALANCE, new BalanceOperationHandlerImpl());
        operationHandlerMap.put(Operation.Type.PURCHASE, new PurchaseOperationHandlerImpl());
        operationHandlerMap.put(Operation.Type.SUPPLY, new SupplyOperationHandlerImpl());
        operationHandlerMap.put(Operation.Type.RETURN, new ReturnOperationHandlerImpl());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitStorageDaoImpl fruitStorageDao = new FruitStorageDaoImpl();
        ReaderService readerService = new ReaderServiceImpl(fruitStorageDao, operationStrategy);

        String inputFileName = "src/main/resources/store_operations.csv";
        List<String> storeData = readerService.readFromFile(inputFileName);
        readerService.packToStorage(storeData);

        String outputFileName = "src/main/resources/report.csv";
        WriterService writerService = new WriterServiceImpl(fruitStorageDao);
        writerService.writeToFile(outputFileName);
    }
}
