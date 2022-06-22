import dao.ItemDao;
import dao.ItemDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import servise.FileReaderService;
import servise.FileWriterService;
import servise.ShopService;
import servise.TransactionService;
import servise.impl.FileReaderServiceImpl;
import servise.impl.FileWriterServiceImpl;
import servise.impl.ShopServiceImpl;
import servise.impl.TransactionServiceImpl;
import servise.transaction.TransactionHandler;
import servise.transaction.impl.BalanceTransactionHandler;
import servise.transaction.impl.PurchaseTransactionHandler;
import servise.transaction.impl.ReturnTransactionHandler;
import servise.transaction.impl.SupplyTransactionHandler;
import strategy.TransactionStrategy;
import strategy.TransactionStrategyImpl;

public class Main {
    private static final String DAILY_RECORDS_FILEPATH = "src/resources/daily_records.csv";
    private static final String DAILY_REPORT_FILEPATH = "src/resources/daily_report.csv";

    public static void main(String[] args) {
        Map<String, TransactionHandler> transactionHandlers = new HashMap<>();
        transactionHandlers.put("b", new BalanceTransactionHandler());
        transactionHandlers.put("s", new SupplyTransactionHandler());
        transactionHandlers.put("p", new PurchaseTransactionHandler());
        transactionHandlers.put("r", new ReturnTransactionHandler());
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(transactionHandlers);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> records = fileReaderService.readFile(DAILY_RECORDS_FILEPATH);

        ItemDao itemDao = new ItemDaoImpl();
        TransactionService transactionService = new TransactionServiceImpl(transactionStrategy);
        ShopService shopService = new ShopServiceImpl(itemDao, transactionService);
        shopService.process(records);

        String report = shopService.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeStringToFile(DAILY_REPORT_FILEPATH, report);
    }
}
