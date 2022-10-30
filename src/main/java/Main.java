import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.operations.BalanceHandler;
import service.operations.OperationHandler;
import service.operations.PurchaseHandler;
import service.operations.ReturnHandler;
import service.operations.SupplyHandler;
import service.process.FruitTransactionService;
import service.process.impl.FruitTransactionServiceImpl;
import service.read.FileReader;
import service.read.FruitTransactionParser;
import service.read.impl.FileReaderImpl;
import service.read.impl.FruitTransactionParserImpl;
import service.strategy.OperationStrategy;
import service.strategy.impl.OperationStrategyImpl;
import service.write.ReportService;
import service.write.WriterService;
import service.write.impl.ReportServiceImpl;
import service.write.impl.WriterServiceImpl;

public class Main {
    private static Map<FruitTransaction.Operation,
            OperationHandler> operationOperationsHandlerMap = new HashMap<>();
    private static StorageDao storageDao = new StorageDaoImpl();
    private static FileReader fileReader = new FileReaderImpl();
    private static ReportService reportService = new ReportServiceImpl();
    private static String CSV_SEPARATOR = ",";
    private static String OPERATION_TYPE_NAME = "type";
    private static String FRUIT_QUANTITY_NAME = "quantity";
    private static String FRUIT_NAME = "fruit";
    private static FruitTransactionParser fruitTransactionParser =
            new FruitTransactionParserImpl(CSV_SEPARATOR, OPERATION_TYPE_NAME,
                    FRUIT_QUANTITY_NAME, FRUIT_NAME);
    private static WriterService writerService = new WriterServiceImpl();
    private static OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationOperationsHandlerMap);
    private static FruitTransactionService fruitTransactionService =
            new FruitTransactionServiceImpl(operationStrategy);

    public static void main(String[] args) {
        operationOperationsHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(storageDao));
        operationOperationsHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(storageDao));
        operationOperationsHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(storageDao));
        operationOperationsHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(storageDao));

        String directoryPath = "src/main/resources/";
        String fromFileName = "input.csv";
        List<String> fileContent = fileReader.readFromFile(directoryPath, fromFileName);

        System.out.println(fileContent);
        List<FruitTransaction> transactions = fruitTransactionParser.parse(fileContent);
        fruitTransactionService.processTransactions(transactions);
        System.out.println(Storage.storage);
        String toFileName = "result.csv";
        String report = reportService.createReport();
        writerService.writeToFile(directoryPath, toFileName, report);
    }
}
