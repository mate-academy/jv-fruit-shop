import db.FileWriter;
import db.FileWriterImpl;
import db.TransactionReader;
import db.TransactionReaderImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CreateReportService;
import service.CreateReportServiceImpl;
import service.FruitService;
import service.FruitServiceImpl;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.activities.BalanceHandler;
import service.activities.OperationHandler;
import service.activities.PurchaseHandler;
import service.activities.ReturnHandler;
import service.activities.SupplyHandler;

public class Main {
    private static final String filePath =
            "/Users/nazar5n/IdeaProjects/jv-fruit-shop/src/main/java/storage/file.csv";
    private static final TransactionReader readFile = new TransactionReaderImpl();
    private static final FileWriter writeToFile = new FileWriterImpl();
    private static final CreateReportService createReport = new CreateReportServiceImpl();

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);

        List<FruitTransaction> dataFromCsv = readFile.readTransactionsFromFile(filePath);

        String report = createReport.generateReport(fruitService.processData(dataFromCsv));
        writeToFile.writeToFile(report);
    }
}
