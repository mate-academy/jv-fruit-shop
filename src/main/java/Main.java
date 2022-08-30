import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitTransactionParserService;
import service.ReportCreatorService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitTransactionParserServiceImpl;
import service.impl.ReportCreatorServiceImpl;
import strategy.Strategy;
import strategy.StrategyImpl;
import strategy.operations.OperationHandler;
import strategy.operations.impl.BalanceOperationHandlerImpl;
import strategy.operations.impl.PurchaseOperationHandlerImpl;
import strategy.operations.impl.ReturnOperationHandlerImpl;
import strategy.operations.impl.SupplyOperationHandlerImpl;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/resources/Input.csv";
    private static final String REPORT_FILEPATH = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl(storageDao));

        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> dateFromFile = fileReader.readFromFile(INPUT_FILEPATH);
        FruitTransactionParserService parserService = new FruitTransactionParserServiceImpl();
        List<FruitTransaction> fruitTransactionList = parserService.parse(dateFromFile);
        Strategy operationStrategy = new StrategyImpl(operationHandlerMap);
        fruitTransactionList.forEach(f -> operationStrategy
                .get(f.getOperation())
                .handler(f));
        ReportCreatorService creatorReportService = new ReportCreatorServiceImpl(storageDao);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(creatorReportService.createReport(), REPORT_FILEPATH);
    }
}
