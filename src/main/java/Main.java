import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruits;
import service.CreatorReportService;
import service.FileReaderService;
import service.FileWriterService;
import service.ParserService;
import service.impl.CreatorReportServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.ParserServiceImpl;
import strategy.Strategy;
import strategy.StrategyImpl;
import strategy.operations.OperationHandler;
import strategy.operations.impl.BalanceOperation;
import strategy.operations.impl.PurchaseOperation;
import strategy.operations.impl.ReturnOperation;
import strategy.operations.impl.SupplyOperation;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/java/files/Input.csv";
    private static final String REPORT_FILEPATH = "src/main/java/files/Report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<Fruits.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruits.Operation.BALANCE,
                new BalanceOperation(storageDao));
        operationHandlerMap.put(Fruits.Operation.PURCHASE,
                new PurchaseOperation(storageDao));
        operationHandlerMap.put(Fruits.Operation.RETURN,
                new ReturnOperation(storageDao));
        operationHandlerMap.put(Fruits.Operation.SUPPLY,
                new SupplyOperation(storageDao));

        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> dateFromFile = fileReader.readFromFile(INPUT_FILEPATH);
        ParserService parserService = new ParserServiceImpl();
        List<Fruits> fruitTransactionList = parserService.parse(dateFromFile);
        Strategy operationStrategy = new StrategyImpl(operationHandlerMap);
        fruitTransactionList.forEach(f -> operationStrategy
                .getOperationTypeFruit(f.getOperation())
                .handler(f));
        CreatorReportService creatorReportService = new CreatorReportServiceImpl(storageDao);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(creatorReportService.createReport(), REPORT_FILEPATH);
    }
}
