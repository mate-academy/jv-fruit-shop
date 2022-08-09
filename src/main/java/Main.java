import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.Parser;
import service.Reader;
import service.ReportCreateService;
import service.Writer;
import service.impl.ParserImpl;
import service.impl.ReaderImpl;
import service.impl.ReportCreateServiceImpl;
import service.impl.WriterImpl;
import strategy.BalanceOperationHandlerImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperationHandlerImpl;
import strategy.ReturnOperationHandlerImpl;
import strategy.SupplyOperationHandlerImpl;

public class Main {
    private static final String FILEPATH_DAILY_RECORDS = "src/main/java/resources/Input.csv";

    private static final String FILEPATH_DAILY_REPORT = "src/main/java/resources/Report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl(storageDao));

        Reader reader = new ReaderImpl();
        List<String> dataFromFile = reader.fileReader(FILEPATH_DAILY_RECORDS);
        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactionList = parser.parseData(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fruitTransactionList.forEach(fruitTransaction -> operationStrategy
                .getOperationType(fruitTransaction.getOperation())
                .changeQuantity(fruitTransaction));
        ReportCreateService reportCreateService = new ReportCreateServiceImpl(storageDao);
        Writer writer = new WriterImpl();
        writer.writeToFile(reportCreateService.createReport(), FILEPATH_DAILY_REPORT);

    }
}
