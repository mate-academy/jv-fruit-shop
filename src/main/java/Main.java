import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.FruitStrategy;
import service.ParserService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitStrategyImpl;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationsStrategy;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    private static final String SOURCE_PATH = "src/main/java/resources/database.csv";
    private static final String REPORT_PATH = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<Fruit.Operation, OperationsStrategy> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruit.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(Fruit.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Fruit.Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(Fruit.Operation.SUPPLY, new SupplyOperation());
        ParserService parserService = new ParserServiceImpl();
        ReaderService readDataService = new ReaderServiceImpl(parserService);
        FruitStrategy fruitStrategy =
                new FruitStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl();
        WriterService writeToFileService = new WriterServiceImpl();
        List<Fruit> fruitList = readDataService.readFromFile(SOURCE_PATH);
        for (Fruit fruit : fruitList) {
            OperationsStrategy operationsStrategy = fruitStrategy.get(fruit.getOperation());
            operationsStrategy.handle(fruit);
        }
        writeToFileService.writeToFile(reportService.getReport(), REPORT_PATH);
    }
}
