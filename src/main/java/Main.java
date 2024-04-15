import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitService;
import service.ReportService;
import service.TransactionMapperService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.activities.BalanceHandler;
import strategy.activities.OperationHandler;
import strategy.activities.PurchaseHandler;
import strategy.activities.ReturnHandler;
import strategy.activities.SupplyHandler;

public class Main {
    private static final String REPORT_PATH = "src/main/resources/dailyReport.csv";
    private static final String FILE_PATH = "src/main/resources/file.csv";
    private static final FileReaderService readFile = new FileReaderServiceImpl();
    private static final FileWriterService fileWriter = new FileWriterServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final TransactionMapperService transactionMapperService =
            new TransactionMapperService();

    public static void main(String[] args) {
        String inputFileLines = readFile.read(FILE_PATH);

        List<FruitTransaction> transactions =
                transactionMapperService.stringToFruitTransaction(inputFileLines);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processTransactions(transactions);

        String reportFile = reportService.generateReport();

        fileWriter.writeToFile(reportFile, REPORT_PATH);
    }
}
