package core.basesyntax.service.implementation;

import core.basesyntax.action.Action;
import core.basesyntax.action.ActionHandler;
import core.basesyntax.dao.DataDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.implementation.DataDaoImpl;
import core.basesyntax.dao.implementation.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final ActionStrategy actionStrategy;
    private final FruitDao fruitDao;
    private final DataDao dataDao;

    public ReportServiceImpl(Map<Action, ActionHandler> actionHandlersMap) {
        actionStrategy = new ActionStrategyImpl(actionHandlersMap);
        fruitDao = new FruitDaoImpl();
        dataDao = new DataDaoImpl();
    }

    @Override
    public String getReport() {
        processData();
        return createReport();
    }

    private void processData() {
        for (String string : dataDao.getData()) {
            int newAmount = actionStrategy
                    .get(getAction(string))
                    .performAction(getFruitName(string),
                            getAmount(string));
            fruitDao.update(getFruitName(string), newAmount);
        }
    }

    private String createReport() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(HEADER)
                .append(System.lineSeparator());
        fruitDao.getMap().forEach((fruitName, amount) -> {
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
