package core.basesyntax.service.implementation;

import core.basesyntax.action.Action;
import core.basesyntax.action.ActionHandler;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.validator.ReportValidator;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final ReportValidator reportValidator;
    private final ActionStrategy actionStrategy;
    private final StorageDao storageDao;

    public ReportServiceImpl(Map<Action, ActionHandler> actionHandlersMap) {
        reportValidator = new ReportValidator();
        actionStrategy = new ActionStrategyImpl(actionHandlersMap);
        storageDao = new StorageDaoImpl();
    }

    private void processData(List<String> dataFromFile) {
        for (String string : dataFromFile) {
            Action action = Action.getAction(string
                    .split(COMMA)[ACTION_INDEX]);
            Fruit fruit = storageDao.get(string
                    .split(COMMA)[FRUIT_INDEX]);
            int amount = Integer.parseInt(string
                    .split(COMMA)[AMOUNT_INDEX]);
            fruit.setAmount(actionStrategy.get(action)
                    .performAction(fruit, amount));
            storageDao.update(fruit);
        }
    }

    private String createReport() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(HEADER)
                .append(System.lineSeparator());
        List<Fruit> listOfFruits = storageDao.getList();
        listOfFruits.forEach(fruit -> {
            reportValidator.validate(fruit.getAmount());
            stringBuilder
                    .append(fruit.getName())
                    .append(COMMA)
                    .append(fruit.getAmount())
                    .append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }

    @Override
    public String getReport(List<String> dataFromFile) {
        processData(dataFromFile);
        return createReport();
    }
}
