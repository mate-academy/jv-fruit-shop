package core.basesyntax.service;

import core.basesyntax.model.Action;
import core.basesyntax.strategy.BaseReportService;
import core.basesyntax.strategy.PurchaseReportService;
import core.basesyntax.strategy.ReportService;
import core.basesyntax.strategy.SupplyReportService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionReader {
    private static final CsvHandlerImpl mapHandler = new CsvHandlerImpl();

    public Map<String, Integer> inputDataToMap(String path) {
        Map<String, Integer> stock = new HashMap<>();
        List<Action> actionList = mapHandler.read(path);
        actionList.forEach(a -> {
            ReportService reportService;
            String action = a.getAction();
            String data = a.getData();
            switch (action) {
                case "b":
                    reportService = new BaseReportService();
                    break;
                case "s":
                case "r":
                    reportService = new SupplyReportService();
                    break;
                case "p":
                    reportService = new PurchaseReportService();
                    break;
                default:
                    throw new RuntimeException(
                            "Error within a file: Action is not specified correctly");
            }
            reportService.apply(stock, data);
        });
        return stock;
    }
}
