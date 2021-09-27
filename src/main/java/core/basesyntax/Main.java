package core.basesyntax;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.FruitOperationListCreateServiceImpl;
import core.basesyntax.service.FruitReportServiceImpl;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReadServiceImpl;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.service.handler.BalanceHandler;
import core.basesyntax.service.handler.PurchaseHandler;
import core.basesyntax.service.handler.ReturnHandler;
import core.basesyntax.service.handler.SupplyHandler;
import core.basesyntax.service.inter.FruitOperationListCreateService;
import core.basesyntax.service.inter.FruitReportService;
import core.basesyntax.service.inter.FruitShopService;
import core.basesyntax.service.inter.Operation;
import core.basesyntax.service.inter.ReadService;
import core.basesyntax.service.inter.WriteService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Operation> operationsHandlers = new HashMap<>();
        operationsHandlers.put("b", new BalanceHandler());
        operationsHandlers.put("p", new PurchaseHandler());
        operationsHandlers.put("r", new ReturnHandler());
        operationsHandlers.put("s", new SupplyHandler());

        ReadService readService = new ReadServiceImpl();
        List<String> dataFromFile = readService.readFromFile("src/main/java/resources/input.csv");

        FruitOperationListCreateService fruitOperationListCreateService =
                new FruitOperationListCreateServiceImpl();
        List<FruitOperation> fruitOperations =
                fruitOperationListCreateService.getFruitOperationsList(dataFromFile);

        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.updateStorageInfo(fruitOperations, operationsHandlers);

        FruitReportService fruitReportService = new FruitReportServiceImpl();
        String report = fruitReportService.createReport();

        WriteService writeService = new WriterServiceImpl();
        writeService.writeToFile("src/main/java/resources/output.csv",
                report);
    }
}
