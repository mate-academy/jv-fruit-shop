import impl.ReadFileImpl;
import impl.ReportServiceImpl;
import impl.TransactionParserImpl;
import impl.TransactionServiceImpl;
import impl.WriteToFileImpl;
import impl.operation.OperationStrategy;
import impl.operation.OperationStrategyImpl;
import impl.operation.operations.BalanceHandlerImpl;
import impl.operation.operations.OperationHandler;
import impl.operation.operations.PurchaseHandlerImpl;
import impl.operation.operations.ReturnHandlerImpl;
import impl.operation.operations.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.ReadFileService;
import service.ReportService;
import service.TransactionParser;
import service.TransactionService;
import service.WriteToFileService;

public class Main {
    private static final String PATH_TO_INPUT_INFO_FILE = "src/main/resources/inputInfo.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandlerImpl());
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandlerImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        ReadFileService readFileService = new ReadFileImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriteToFileService writeToFileService = new WriteToFileImpl();

        List<String> fileInfo = readFileService.readFile(PATH_TO_INPUT_INFO_FILE);
        List<FruitTransaction> fruitTransactions = transactionParser
                .parseTransactions(fileInfo);
        transactionService.processTransactions(fruitTransactions);
        String report = reportService.createReport();
        writeToFileService.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
