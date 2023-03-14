package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ActionReader;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.actions.ActionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionReaderImpl implements ActionReader {
    private static final CsvManagerImpl csvManager = new CsvManagerImpl();

    public Map<String, Integer> inputDataToMap(List<ActionHandler> possibleActions, String path) {
        Map<String, Integer> stock = new HashMap<>();
        List<Transaction> actionList = csvManager.read(path);
        actionList.forEach(a -> {
            String action = a.getAction();
            String data = a.getData();
            new ActionStrategy(possibleActions).get(action).apply(stock, data);
        });
        return stock;
    }

    public void outputMapToFile(Map<String, Integer> data, String path) {
        csvManager.report(data, path);
    }
}
