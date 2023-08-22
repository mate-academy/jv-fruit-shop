package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CheckDataService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.CheckDataServiceImpl;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String DAY_ACTIVITY_CSV
            = "src/main/resources/dayActivities.csv";
    public static final String DAY_REPORT_CSV
            = "src/main/resources/dayReport.csv";
    private static final Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();

    static {
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
    }

    public static void main(String[] args) {
        FileService fileDao = new FileServiceImpl();
        CheckDataService checkDataService = new CheckDataServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(
                new OperationStrategyImpl(operationHandlerMap));
        ReportService reportService = new ReportServiceImpl();

        List<String> dataFromFile = fileDao.readFromFile(DAY_ACTIVITY_CSV);

        checkDataService.checkData(dataFromFile);

        List<FruitTransaction> fruitTransactionList =
                parseService.parseTransaction(dataFromFile);

        fruitShopService.executeTransactions(fruitTransactionList);

        String report = reportService.getReport();

        fileDao.writeToFile(DAY_REPORT_CSV, report);
    }
}
