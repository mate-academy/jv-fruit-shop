import db.FileWriter;
import db.FileWriterImpl;
import db.TransactionReader;
import db.TransactionReaderImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitService;
import service.FruitServiceImpl;
import service.ReportService;
import service.ReportServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.activities.BalanceHandler;
import strategy.activities.OperationHandler;
import strategy.activities.PurchaseHandler;
import strategy.activities.ReturnHandler;
import strategy.activities.SupplyHandler;

public class Main {
    private static final String filePath = "src/main/resources/file.csv"; // data from file
    private static final TransactionReader readFile = new TransactionReaderImpl();
    private static final FileWriter fileWriter = new FileWriterImpl();
    private static final ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        // read and convert data
        List<FruitTransaction> dataFromCsv = readFile.readTransactionsFromFile(filePath);

        // process
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();

        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);

        // create report
        String report = reportService.generateReport(fruitService.processData(dataFromCsv));

        // write report to file
        fileWriter.writeToFile(report);
    }
}
