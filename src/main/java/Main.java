import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReader;
import service.FileWriter;
import service.Parser;
import service.ReportCreatorService;
import service.impl.FileWriterImpl;
import service.impl.ParserImpl;
import service.impl.ReaderImpl;
import service.impl.ReportCreatorServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperationHandlerImpl;
import strategy.ReturnOperationHandlerImpl;
import strategy.SupplyOperationHandlerImpl;

public class Main {
    private static final String FILEPATH_DAILY_RECORDS = "src/main/resources/Input.csv";

    private static final String FILEPATH_DAILY_REPORT = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl(storageDao));

        FileReader reader = new ReaderImpl();
        List<String> dataFromFile = reader.read(FILEPATH_DAILY_RECORDS);
        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactionList = parser.parseData(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fruitTransactionList.forEach(fruitTransaction -> operationStrategy
                .getOperationType(fruitTransaction.getOperation())
                .handle(fruitTransaction));
        ReportCreatorService reportCreateService = new ReportCreatorServiceImpl(storageDao);
        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(reportCreateService.createReport(), FILEPATH_DAILY_REPORT);

    }
}
