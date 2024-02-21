package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.CsvConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileMaster;
import core.basesyntax.service.Operation;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.ShopServiceStrategy;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    private static final File DATA_FROM = new File("src/main/resources/TryMe.csv");
    private static File dataTo; //not  a constant path, changes in time based on my localDateTime

    public static void main(String[] args) {
        Map<Operation, OperationHandler> opHandlerMap = new HashMap<>();
        opHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        opHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        opHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        opHandlerMap.put(Operation.RETURN, new ReturnHandler());

        ShopServiceImpl customShopService = new ShopServiceImpl(
                new ShopServiceStrategy(opHandlerMap), new FileReader(), new CsvConverter(),
                new FileMaster(), new StorageDaoImpl());

        String dataToProcess = customShopService.readAndConvert(DATA_FROM);
        customShopService.processData(dataToProcess);
        File blankReportDestinationFile = customShopService.createReport(DATA_FROM);
        File report = customShopService.writeReportToFile(blankReportDestinationFile);
        dataTo = new File("" + report.toPath());
    }
}
