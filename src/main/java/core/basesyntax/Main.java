package core.basesyntax;

import core.basesyntax.action.ActionHandler;
import core.basesyntax.action.Actions;
import core.basesyntax.action.BalanceHandler;
import core.basesyntax.action.PurchaseHandler;
import core.basesyntax.action.ReturnHandler;
import core.basesyntax.action.SupplyHandler;
import core.basesyntax.servise.ReportService;
import core.basesyntax.servise.implementations.FileServiceImpl;
import core.basesyntax.servise.implementations.ReportServiceImpl;
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
    public static final Map<Actions, ActionHandler> actionHandlersMap = Map.of(
            Actions.B, balanceHandler,
            Actions.R, returnHandler,
            Actions.P, purchaseHandler,
            Actions.S, supplyHandler);
    public static final FileServiceImpl fileService = new FileServiceImpl();
    public static final ReportService reportService = new ReportServiceImpl(actionHandlersMap);

    public static void main(String[] args) {
        List<String> dataFromFile = fileService
                .readFromFile(FROM_FILE_PATH);
        String report = reportService.getReport(dataFromFile);
        fileService.createReportFile(report);
    }
}
