package core.basesyntax;

import core.basesyntax.service.CsvConverter;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.FileMaster;
import core.basesyntax.service.Operation;
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
    private static final String FILE_TO_REPORT1 = "src/main/resources/TryMe.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> opHandlerMap = new HashMap<>();
        opHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        opHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        opHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        opHandlerMap.put(Operation.RETURN, new ReturnHandler());

        ShopServiceImpl customShopService = new ShopServiceImpl(
                new ShopServiceStrategy(opHandlerMap), new CsvReader(), new CsvConverter(),
                new FileMaster());

        String dataToProcess = customShopService.readAndConvert(FILE_TO_REPORT1);
        customShopService.processData(dataToProcess);
        String outputPath = customShopService.createReport(FILE_TO_REPORT1);
        customShopService.writeReportToFile(outputPath);
    }
}
