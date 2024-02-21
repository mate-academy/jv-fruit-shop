package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.CsvConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileServise;
import core.basesyntax.service.Operation;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.ShopServiceStrategy;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    private static final DateTimeFormatter FORMATTED = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd_HH-mm-ss");
    private static final String INPUT_DATA_FILE = "src/main/resources/TryMe.csv";
    private static final String OUTPUT_DATA_FILE = "src" + File.separator
                + "main" + File.separator
                + "resources" + File.separator
                + "report_" + LocalDateTime.now().format(FORMATTED)
            + ".csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> opHandlerMap = new HashMap<>();
        opHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        opHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        opHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        opHandlerMap.put(Operation.RETURN, new ReturnHandler());

        ShopServiceImpl customShopService = new ShopServiceImpl(
                new ShopServiceStrategy(opHandlerMap), new FileReader(), new CsvConverter(),
                new FileServise(), new StorageDaoImpl());

        customShopService.report(INPUT_DATA_FILE, OUTPUT_DATA_FILE);
    }
}
