import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderServiceImpl;
import service.FileWriterServiceImpl;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ParseServiceImpl;
import service.ReportServiceImpl;
import service.operation.BalanceOperationHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseOperationHandler;
import service.operation.ReturnOperationHandler;
import service.operation.SupplyOperationHandler;

public class Main {
    private static final String DATABASE_CSV_FILE_NAME = "src/main/java/database.csv";
    private static final String REPORT_CSV_FILE_NAME = "src/main/java/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        List<String> stringsFromCsvFile = new FileReaderServiceImpl()
                .readFromFile(DATABASE_CSV_FILE_NAME);
        List<FruitTransaction> fruitTransactions = new ParseServiceImpl().parse(stringsFromCsvFile);
        List<String> report = new ReportServiceImpl().create(fruitTransactions,
                operationStrategy);
        new FileWriterServiceImpl().writeToFile(report, REPORT_CSV_FILE_NAME);
    }
}
