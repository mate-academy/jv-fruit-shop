import core.fruitshop.OperationType;
import core.fruitshop.dao.StorageDao;
import core.fruitshop.dao.StorageDaoImpl;
import core.fruitshop.db.Storage;
import core.fruitshop.model.FruitTransaction;
import core.fruitshop.services.DataExtractor;
import core.fruitshop.services.FileWorker;
import core.fruitshop.services.impl.CSVDataExtractorImpl;
import core.fruitshop.services.impl.FileWorkerImpl;
import core.fruitshop.strategy.implementation.*;
import core.fruitshop.strategy.interfaces.OperationHandler;
import core.fruitshop.strategy.interfaces.OperationStrategy;

import java.util.List;
import java.util.Map;


public class Main {
    private static final String COLUMN_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String DATA_FILE_HEADER = "type,fruit,quantity";
    private static final String DATA_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<OperationType, OperationHandler> handlerMap =
                Map.of(OperationType.BALANCE, new BalanceOperationHandler(storageDao),
                        OperationType.PURCHASE, new PurchaseOperationHandler(storageDao),
                        OperationType.RETURN, new ReturnOperationHandler(storageDao),
                        OperationType.SUPPLY, new SupplyOperationHandler(storageDao));
        FileWorker fileWorker = new FileWorkerImpl();
        DataExtractor dataExtractor = new CSVDataExtractorImpl(COLUMN_SEPARATOR);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        List<String> lines = fileWorker.readFromFile(DATA_FILE_PATH);
        for (String line : lines) {
            if(line.contains(DATA_FILE_HEADER)) {
                continue;
            }
            FruitTransaction transaction = dataExtractor.parse(line);
            operationStrategy.getStrategy(transaction.getType()).handle(transaction.getProductName(),
                    transaction.getAmount());
        }
        fileWorker.writeToFile(REPORT_FILE_PATH, REPORT_HEADER, COLUMN_SEPARATOR, Storage.fruitsStorage);
    }
}
