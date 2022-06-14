import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CsvFileReaderService;
import service.FileWriterService;
import service.FruitDao;
import service.OperationHandler;
import service.OperationStrategy;
import service.ParseService;
import service.ShopService;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvParseServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.ShopServiceImplementation;
import service.impl.StorageImplementation;
import strategy.AddOperationHandler;
import strategy.OperationStrategyImplementation;
import strategy.SetBalanceOperationHandler;
import strategy.SubtractOperationHandler;

public class Main {
    private static final String FROM_FILE = "src/main/resources/fruit_shop.csv";
    private static final String TO_FILE = "src/main/resources/fruit_shop_report.csv";

    public static void main(String[] args) {
        CsvFileReaderService fileService = new CsvFileReaderServiceImpl();
        final List<String[]> listTransactions = fileService.readFile(FROM_FILE);
        ParseService parseService = new CsvParseServiceImpl();
        final List<FruitTransaction> transactions =
                parseService.parse(listTransactions.subList(1, listTransactions.size()));
        FruitDao fruitDao = new StorageImplementation();
        Map<FruitTransaction.Operation, OperationHandler> mapOperation = new HashMap<>();
        mapOperation.put(FruitTransaction.Operation.BALANCE,
                new SetBalanceOperationHandler(fruitDao));
        mapOperation.put(FruitTransaction.Operation.PURCHASE,
                new SubtractOperationHandler(fruitDao));
        mapOperation.put(FruitTransaction.Operation.RETURN,
                new AddOperationHandler(fruitDao));
        mapOperation.put(FruitTransaction.Operation.SUPPLY,
                new AddOperationHandler(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImplementation(mapOperation);
        ShopService shopService = new ShopServiceImplementation(fruitDao);
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getOperationHandler(transaction.getOperation())
                    .doTransaction(transaction);
        }
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeFile(TO_FILE, shopService.doReport());
    }
}
