package core.basesyntax;

import core.basesyntax.action.Action;
import core.basesyntax.action.ActionHandler;
import core.basesyntax.action.BalanceHandler;
import core.basesyntax.action.PurchaseHandler;
import core.basesyntax.action.ReturnHandler;
import core.basesyntax.action.SupplyHandler;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.implementation.FileServiceImpl;
import core.basesyntax.service.implementation.FruitServiceImpl;
import core.basesyntax.service.implementation.ReportServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static final String FROM_FILE_PATH = "src/main/resources/test.csv";
    public static final ActionHandler balanceHandler = new BalanceHandler();
    public static final ActionHandler purchaseHandler = new PurchaseHandler();
    public static final ActionHandler returnHandler = new ReturnHandler();
    public static final ActionHandler supplyHandler = new SupplyHandler();
    public static final Map<Action, ActionHandler> actionHandlersMap = Map.of(
            Action.BALANCE, balanceHandler,
            Action.RETURN, returnHandler,
            Action.PURCHASE, purchaseHandler,
            Action.SUPPLY, supplyHandler);
    public static final StorageDao storageDao = new StorageDaoImpl();
    public static final FileServiceImpl fileService = new FileServiceImpl();
    public static final ReportService reportService = new ReportServiceImpl(actionHandlersMap);
    public static final FruitService fruitService = new FruitServiceImpl(storageDao);

    public static void main(String[] args) {
        List<String> dataFromFile = fileService
                .readFromFile(FROM_FILE_PATH);
        fruitService.fillFruitStorage(dataFromFile);



        String report = reportService.getReport(dataFromFile);
        fileService.createReportFile(report);
    }
}
