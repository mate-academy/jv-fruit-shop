import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ReadFromFileService;
import service.ReportService;
import service.TransactionService;
import service.WriteToFileService;
import service.impl.ReadFromFileServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionServiceImpl;
import service.impl.WriteToFileServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.TransactionHandler;
import strategy.impl.BalanceOperationHandler;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationHandler;
import strategy.impl.ReturnOperationHandler;
import strategy.impl.SupplyOperationHandler;
import strategy.impl.TransactionHandlerImpl;

public class Main {
    private static final String INPUT_PATH = "src/main/java/resources/inputData.csv";
    private static final String OUTPUT_PATH = "src/main/java/resources/report.csv";

    public static void main(String[] args) {

        Map<FruitTransaction.Operation, OperationHandler> operationsHandlerMap = new HashMap<>();
        operationsHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationsHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationsHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationsHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());

        ReadFromFileService readService = new ReadFromFileServiceImpl();
        List<String> fruitTransactions = readService.readCsv(INPUT_PATH);

        TransactionService operationService = new TransactionServiceImpl();
        List<FruitTransaction> transactionsList = operationService
                .createTransactionsList(fruitTransactions);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsHandlerMap);
        TransactionHandler operationHandler = new TransactionHandlerImpl(operationStrategy);
        operationHandler.parse(transactionsList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();

        WriteToFileService writeToFileService = new WriteToFileServiceImpl();
        writeToFileService.writeToFile(OUTPUT_PATH, report);

    }
}
