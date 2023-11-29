package core.basesyntax;

import core.basesyntax.action.Action;
import core.basesyntax.action.ActionHandler;
import core.basesyntax.action.BalanceHandler;
import core.basesyntax.action.PurchaseHandler;
import core.basesyntax.action.ReturnHandler;
import core.basesyntax.action.SupplyHandler;
import core.basesyntax.service.DataService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.implementation.FileServiceImpl;
import core.basesyntax.service.implementation.DataServiceImpl;
import core.basesyntax.service.implementation.ReportServiceImpl;
import java.util.List;
import java.util.Map;

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
    public static final FileServiceImpl fileService = new FileServiceImpl();
    public static final ReportService reportService = new ReportServiceImpl(actionHandlersMap);
    public static final DataService dataService = new DataServiceImpl();

    public static void main(String[] args) {
        List<String> dataFromFile = fileService
                .readFromFile(FROM_FILE_PATH);
        List<String> formattedData = dataService
                .formatAndCheckData(dataFromFile);
        dataService.fillFruitStorage(formattedData);
        String report = reportService.getReport(formattedData);
        fileService.writeDataToFile(report);
    }
}
