import core.fruitshop.OperationType;
import core.fruitshop.dao.StorageDao;
import core.fruitshop.dao.StorageDaoImpl;
import core.fruitshop.model.FruitTransaction;
import core.fruitshop.service.DataParser;
import core.fruitshop.service.FileWorker;
import core.fruitshop.service.impl.CsvDataParserImpl;
import core.fruitshop.service.impl.FileWorkerImpl;
import core.fruitshop.strategy.implementation.BalanceOperationHandler;
import core.fruitshop.strategy.implementation.OperationStrategyImpl;
import core.fruitshop.strategy.implementation.PurchaseOperationHandler;
import core.fruitshop.strategy.implementation.ReturnSupplyOperationHandler;
import core.fruitshop.strategy.interfaces.OperationHandler;
import core.fruitshop.strategy.interfaces.OperationStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String COLUMN_SEPARATOR = ",";
    private static final String DATA_FILE_PATH = "src/main/resources/data.csv";
    private static final String DATA_FILE_HEADER = "type,fruit,quantity";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final String REPORT_HEADER = "fruit,quantity";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        OperationHandler returnSupplyHandler = new ReturnSupplyOperationHandler(storageDao);
        Map<OperationType, OperationHandler> handlerMap =
                Map.of(OperationType.BALANCE, new BalanceOperationHandler(storageDao),
                        OperationType.PURCHASE, new PurchaseOperationHandler(storageDao),
                        OperationType.RETURN, returnSupplyHandler,
                        OperationType.SUPPLY, returnSupplyHandler);
        FileWorker fileWorker = new FileWorkerImpl();
        DataParser dataExtractor = new CsvDataParserImpl(COLUMN_SEPARATOR);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        List<String> data;
        data = fileWorker.readFromFile(DATA_FILE_PATH);
        for (String line : data) {
            if (line.contains(DATA_FILE_HEADER)) {
                continue;
            }
            FruitTransaction transaction = dataExtractor.parse(line);
            operationStrategy.getStrategy(transaction.getType())
                    .handle(transaction.getProductName(),
                            transaction.getAmount());
        }

        fileWorker.writeToFile(REPORT_FILE_PATH, REPORT_HEADER,
                COLUMN_SEPARATOR, storageDao.dumpData());

    }
}
