package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.CSvReader;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.ShopServiceStrategy;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.util.HashMap;
import java.util.Map;


public class HelloWorld {
    private static final String FROM_FILE_1 = "src/main/java/core/basesyntax/service/Operation/TryMe.csv";
    public static void main(String[] args) {
        Map<ShopServiceStrategy.Operation, OperationHandler> opHandlerMap = new HashMap<>();
        opHandlerMap.put(ShopServiceStrategy.Operation.BALANCE, new BalanceHandler());
        opHandlerMap.put(ShopServiceStrategy.Operation.SUPPLY, new SupplyHandler());
        opHandlerMap.put(ShopServiceStrategy.Operation.PURCHASE, new PurchaseHandler());
        opHandlerMap.put(ShopServiceStrategy.Operation.RETURN, new ReturnHandler());


        ShopServiceImpl customShopService = new ShopServiceImpl(new ShopServiceStrategy(opHandlerMap),
                new StorageDaoImpl(), new CSvReader());

        String dataToProcess = customShopService.readAndConvert(FROM_FILE_1);
        customShopService.processData(dataToProcess);
        String outputPath = customShopService.createReport(FROM_FILE_1);
        customShopService.writeReport(outputPath);

    }
}
