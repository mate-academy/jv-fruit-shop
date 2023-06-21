import fruit.shop.model.FruitTransaction;
import fruit.shop.service.ReaderService;
import fruit.shop.service.RecordsParser;
import fruit.shop.service.ReportGenerator;
import fruit.shop.service.TransactionHandler;
import fruit.shop.service.WriterService;
import fruit.shop.service.impl.ReaderServiceImpl;
import fruit.shop.service.impl.RecordsParserTransaction;
import fruit.shop.service.impl.ReportGeneratorImpl;
import fruit.shop.service.impl.TransactionHandlerImpl;
import fruit.shop.service.impl.WriterServiceImpl;
import fruit.shop.service.strategy.OperationHandler;
import fruit.shop.service.strategy.OperationStrategy;
import fruit.shop.service.strategy.impl.BalanceHandler;
import fruit.shop.service.strategy.impl.OperationStrategyImpl;
import fruit.shop.service.strategy.impl.PurchaseHandler;
import fruit.shop.service.strategy.impl.ReturnHandler;
import fruit.shop.service.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String EXAMPLE_PATH_FROM = "src/main/resources/input.csv";
    private static final String EXAMPLE_PATH_TO = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> fruitMap = new HashMap<>();
        fruitMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        fruitMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        fruitMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        fruitMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        ReaderService recordsReader = new ReaderServiceImpl();
        RecordsParser parser = new RecordsParserTransaction();
        WriterService writer = new WriterServiceImpl();
        ReportGenerator connector = new ReportGeneratorImpl();
        OperationStrategy strategy = new OperationStrategyImpl(fruitMap);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(strategy);
        List<String> records = recordsReader.getRecords(EXAMPLE_PATH_FROM);
        List<FruitTransaction> transactions = parser.parseRecords(records);
        transactionHandler.parseStorage(transactions);
        writer.writeToFile(EXAMPLE_PATH_TO, connector.generateReport());
    }
}
