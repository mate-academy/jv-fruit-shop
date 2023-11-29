package core.basesyntax.service.implementation;

import core.basesyntax.action.Action;
import core.basesyntax.action.ActionHandler;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final ActionStrategy actionStrategy;
    private final StorageDao storageDao;

    public ReportServiceImpl(Map<Action, ActionHandler> actionHandlersMap) {
        actionStrategy = new ActionStrategyImpl(actionHandlersMap);
        storageDao = new StorageDaoImpl();
    }

    @Override
    public String getReport(List<String> data) {
        processData(data);
        return createReport();
    }

    private void processData(List<String> data) {
        for (String string : data) {
            int newAmount = actionStrategy
                    .get(getAction(string))
                    .performAction(getFruitName(string),
                            getAmount(string));
            storageDao.update(getFruitName(string), newAmount);
        }
    }

    private String createReport() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(HEADER)
                .append(System.lineSeparator());
        storageDao.getMap().forEach((fruitName, amount) -> {
            stringBuilder
                    .append(fruitName)
                    .append(COMMA)
                    .append(amount)
                    .append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }

    private static String getFruitName(String string) {
        return string.split(COMMA)[FRUIT_INDEX];
    }

    private static int getAmount(String string) {
        return Integer.parseInt(string
                .split(COMMA)[AMOUNT_INDEX]);
    }

    private static Action getAction(String string) {
        return Action.getAction(string
                .split(COMMA)[ACTION_INDEX]);
    }
}
