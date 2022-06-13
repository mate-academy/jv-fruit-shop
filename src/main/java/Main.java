import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileService;
import service.OperationHandler;
import service.OperationStrategy;
import service.ParseService;
import service.ShopService;
import service.StorageService;
import service.impl.FileServiceImplementation;
import service.impl.ParseServiceImplementation;
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
        // 1. read data from file
        FileService fileService = new FileServiceImplementation();
        final List<String[]> listTransactions = fileService.readFile(FROM_FILE);
        // 2. get list of transactions by parsing String[] to FruitTransactions:
        ParseService parseService = new ParseServiceImplementation();
        final List<FruitTransaction> transactions = parseService.parse(listTransactions);
        // 3. call method fill and hand data over to the storage
        StorageService storageService = new StorageImplementation();
        Map<FruitTransaction.Operation, OperationHandler> mapOperation = new HashMap<>();
        mapOperation.put(FruitTransaction.Operation.BALANCE,
                new SetBalanceOperationHandler(storageService));
        mapOperation.put(FruitTransaction.Operation.PURCHASE,
                new SubtractOperationHandler(storageService));
        mapOperation.put(FruitTransaction.Operation.RETURN,
                new AddOperationHandler(storageService));
        mapOperation.put(FruitTransaction.Operation.SUPPLY,
                new AddOperationHandler(storageService));
        OperationStrategy operationStrategy = new OperationStrategyImplementation(mapOperation);
        ShopService shopService = new ShopServiceImplementation(storageService, operationStrategy);
        shopService.fill(transactions);
        // 4. call method doReport and write data to the file:
        fileService.writeFile(TO_FILE, shopService.doReport());
    }
}
