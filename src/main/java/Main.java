import impl.CreateReportImpl;
import impl.ParseFruitTransactionsImpl;
import impl.ReadFileImpl;
import impl.ToFruitTransactionImpl;
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
import service.CreateReportService;
import service.ParseFruitTransactionService;
import service.ReadFileService;
import service.ToFruitTransactionService;
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
        ToFruitTransactionService toFruitTransactionService = new ToFruitTransactionImpl();
        ParseFruitTransactionService parseFruitTransactionService =
                new ParseFruitTransactionsImpl(operationStrategy);
        CreateReportService createReportService = new CreateReportImpl();
        WriteToFileService writeToFileService = new WriteToFileImpl();

        List<String> fileInfo = readFileService.readFile(PATH_TO_INPUT_INFO_FILE);
        List<FruitTransaction> fruitTransactions = toFruitTransactionService
                .getListOfFruitTransactions(fileInfo);
        parseFruitTransactionService.parseFruitTransactions(fruitTransactions);
        String report = createReportService.report();
        writeToFileService.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
