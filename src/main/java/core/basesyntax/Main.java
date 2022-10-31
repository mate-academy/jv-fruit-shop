package core.basesyntax;

import core.basesyntax.dao.ParseFruitAction;
import core.basesyntax.dao.ParseShopActivities;
import core.basesyntax.dao.impl.ParseFruitActionImpl;
import core.basesyntax.dao.impl.ParseShopActivitiesImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.impl.BalanceHandler;
import core.basesyntax.service.handler.impl.PurchaseHandler;
import core.basesyntax.service.handler.impl.ReturnHandler;
import core.basesyntax.service.handler.impl.SupplyHandler;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FROM = "src/main/resources/dataFrom.csv";
    private static final String PATH_TO = "src/main/resources/dataTo.csv";

    public static void main(String[] args) {
        FileReaderService readFromFileService = new FileReaderServiceImpl();
        String dataFromFile = readFromFileService.readFile(PATH_FROM);

        ParseShopActivities getFruitShopActivities = new ParseShopActivitiesImpl();
        String[] activities = getFruitShopActivities.parseActivities(dataFromFile);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        ParseFruitAction parseFruitAction = new ParseFruitActionImpl();
        List<FruitTransaction> transactions = parseFruitAction.parseAction(activities);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationHandlersMap);
        fruitShopService.transfer(transactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        FileWriterService writeInFileService = new FileWriterServiceImpl();
        writeInFileService.writeInFile(report, PATH_TO);
        System.out.println(readFromFileService.readFile(PATH_TO));
    }
}
