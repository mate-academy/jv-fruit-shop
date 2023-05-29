import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitStrategyImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperation;
import strategy.FruitStrategy;
import strategy.OperationsStrategy;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    private static final String FILE_FROM_DB = "database.csv";
    private static final String FILE_REPORT = "report.csv";

    public static void main(String[] args) {
        Map<Fruit.Operation, OperationsStrategy> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruit.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(Fruit.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Fruit.Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(Fruit.Operation.SUPPLY, new SupplyOperation());
        ReaderService readDataService = new ReaderServiceImpl();
        FruitStrategy fruitStrategy =
                new FruitStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl();
        WriterService writeToFileService = new WriterServiceImpl();
        List<Fruit> fruitList = readDataService.readFromFile(FILE_FROM_DB);
        for (Fruit fruit : fruitList) {
            OperationsStrategy operationsStrategy = fruitStrategy.get(fruit.getOperation());
            operationsStrategy.handle(fruit);
        }
        writeToFileService.writeToFile(reportService.getReport(), FILE_REPORT);
    }
}
