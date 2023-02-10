import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FileService;
import service.ReportGenerator;
import service.TransactionParser;
import service.TransactionProcessor;
import service.impl.FileServiceImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.TransactionParserImpl;
import service.impl.TransactionProcessorImpl;
import strategy.OperationStrategy;
import strategy.handler.OperationHandler;
import strategy.handler.impl.BalanceHandler;
import strategy.handler.impl.PurchaseHandler;
import strategy.handler.impl.ReturnHandler;
import strategy.handler.impl.SupplyHandler;
import strategy.impl.OperationStrategyImpl;

public class Main {
    private static final String TRANSACTION_FILE = "src/main/resources/transactions.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();

        List<String> stringOfTransactions = fileService
                .readFromFile(TRANSACTION_FILE);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser
                .parseData(stringOfTransactions);

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationStrategy);
        Map<String, Integer> operationResult = transactionProcessor.process(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport(operationResult);

        fileService.writeToFile(report, REPORT_FILE);
    }
}
