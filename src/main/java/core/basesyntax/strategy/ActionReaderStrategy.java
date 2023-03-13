package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.CsvManagerImpl;
import core.basesyntax.strategy.actions.ActionHandler;
import core.basesyntax.strategy.actions.BaseActionHandler;
import core.basesyntax.strategy.actions.PurchaseActionHandler;
import core.basesyntax.strategy.actions.SupplyActionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionReaderStrategy {
    private static final CsvManagerImpl mapHandler = new CsvManagerImpl();

    public Map<String, Integer> inputDataToMap(String path) {
        Map<String, Integer> stock = new HashMap<>();
        List<Transaction> actionList = mapHandler.read(path);
        actionList.forEach(a -> {
            ActionHandler reportService;
            String action = a.getAction();
            String data = a.getData();
            switch (action) {
                case "b":
                    reportService = new BaseActionHandler();
                    break;
                case "s":
                case "r":
                    reportService = new SupplyActionHandler();
                    break;
                case "p":
                    reportService = new PurchaseActionHandler();
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
