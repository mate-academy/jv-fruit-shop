import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.operations.BalanceHandler;
import service.operations.OperationsHandler;
import service.operations.PurchaseHandler;
import service.operations.ReturnHandler;
import service.operations.SupplyHandler;
import service.process.ProcessTransactionsService;
import service.process.impl.ProcessTransactionsServiceImpl;
import service.read.ProcessFileContent;
import service.read.ReadFileService;
import service.read.impl.ProcessFileContentImpl;
import service.read.impl.ReadFileServiceImpl;
import service.strategy.OperationsStrategy;
import service.strategy.impl.OperationsStrategyImpl;
import service.write.WriterService;
import service.write.impl.WriterServiceImpl;

public class Main {
    private static Map<FruitTransaction.Operation,
            OperationsHandler> operationOperationsHandlerMap = new HashMap<>();
    private static StorageDao storageDao = new StorageDaoImpl();
    private static ReadFileService readerService = new ReadFileServiceImpl();
    private static ProcessFileContent processFileService = new ProcessFileContentImpl();
    private static WriterService writerService = new WriterServiceImpl();
    private static OperationsStrategy operationsStrategy =
            new OperationsStrategyImpl(operationOperationsHandlerMap);
    private static ProcessTransactionsService processTransactionsService =
            new ProcessTransactionsServiceImpl(operationsStrategy);

    public static void main(String[] args) {
        operationOperationsHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(storageDao));
        operationOperationsHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(storageDao));
        operationOperationsHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(storageDao));
        operationOperationsHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(storageDao));

        String filePath = "src/main/resources/input.csv";
        List<String> fileContent = readerService.readFromFile(filePath);
        System.out.println(fileContent);
        List<FruitTransaction> transactions = processFileService.processFile(fileContent);
        processTransactionsService.processTransactions(transactions);
        System.out.println(Storage.storage);
        String toFileName = "result.csv";
        writerService.writeToFile(toFileName);
    }
}
