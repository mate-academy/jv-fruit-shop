import core.fruitshop.OperationType;
import core.fruitshop.dao.StorageDao;
import core.fruitshop.dao.StorageDaoImpl;
import core.fruitshop.services.DataExtractor;
import core.fruitshop.services.FileWorker;
import core.fruitshop.services.FruitShopService;
import core.fruitshop.services.impl.CSVDataExtractorImpl;
import core.fruitshop.services.impl.FileWorkerImpl;
import core.fruitshop.services.impl.FruitShopServiceImpl;
import core.fruitshop.strategy.implementation.*;
import core.fruitshop.strategy.interfaces.OperationHandler;
import core.fruitshop.strategy.interfaces.OperationStrategy;

import java.util.Map;


public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        OperationHandler returnSupplyHandler = new ReturnSupplyOperationHandler(storageDao);
        Map<OperationType, OperationHandler> handlerMap =
                Map.of(OperationType.BALANCE, new BalanceOperationHandler(storageDao),
                        OperationType.PURCHASE, new PurchaseOperationHandler(storageDao),
                        OperationType.RETURN, returnSupplyHandler,
                        OperationType.SUPPLY, returnSupplyHandler);
        FileWorker fileWorker = new FileWorkerImpl();
        DataExtractor dataExtractor = new CSVDataExtractorImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(fileWorker,
                dataExtractor, operationStrategy);
        fruitShopService.processData(DATA_FILE_PATH);
        fruitShopService.createReport(REPORT_FILE_PATH);
    }
}
