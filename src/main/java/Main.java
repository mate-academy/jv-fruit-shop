import java.io.File;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.FileService;
import service.OperationService;
import service.ShopService;
import service.StorageService;
import service.impl.FileServiceImplementation;
import service.impl.ShopServiceImplementation;
import service.impl.StorageImplementation;
import strategy.AddOperationImplementation;
import strategy.OperationHandler;
import strategy.SetBalanceOperationImplementation;
import strategy.SubtractOperationImplementation;

public class Main {
    private static final String FROM_FILE = "src/main/fruit_shop.csv";
    private static final String TO_FILE = "src/main/fruit_shop_report.csv";

    public static void main(String[] args) {
        StorageService storageService = new StorageImplementation();
        Map<FruitTransaction.Operation, OperationService> mapOperation = new HashMap<>();
        mapOperation.put(FruitTransaction.Operation.BALANCE,
                new SetBalanceOperationImplementation(storageService));
        mapOperation.put(FruitTransaction.Operation.PURCHASE,
                new SubtractOperationImplementation(storageService));
        mapOperation.put(FruitTransaction.Operation.RETURN,
                new AddOperationImplementation(storageService));
        mapOperation.put(FruitTransaction.Operation.SUPPLY,
                new AddOperationImplementation(storageService));
        OperationHandler operationHandler = new OperationHandler(mapOperation);
        ShopService shopService = new ShopServiceImplementation(storageService, operationHandler);
        File file = new File(FROM_FILE);
        FileService fileService = new FileServiceImplementation();
        shopService.fill(fileService.read(file));
        File reportFile = new File(TO_FILE);
        fileService.writeFile(reportFile, shopService.doReport());
    }
}
