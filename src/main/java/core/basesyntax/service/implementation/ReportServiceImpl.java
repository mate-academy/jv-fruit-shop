package core.basesyntax.service.implementation;

import core.basesyntax.action.ActionHandler;
import core.basesyntax.action.Action;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.validator.ReportValidator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int INSTANCE_FIELD_INDEX = 0;
    private static ReportValidator reportValidator;
    private final ActionStrategy actionStrategy;

    public ReportServiceImpl(Map<Action, ActionHandler> actionHandlersMap) {
        reportValidator = new ReportValidator();
        actionStrategy = new ActionStrategyImpl(actionHandlersMap);
    }

    @Override
    public String getReport(List<String> dataFromFile) {
        List<List<String>> sortedData = sortByFruits(dataFromFile);
        return processData(sortedData);
    }

    private List<List<String>> sortByFruits(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(1)
                .collect(Collectors.groupingBy(string ->
                        string.split(COMMA)[FRUIT_INDEX]))
                .values()
                .stream()
                .toList();
    }

    private String processData(List<List<String>> sortedList) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(HEADER)
                .append(System.lineSeparator());
        for (List<String> listOfFields : sortedList) {
            stringBuilder.append(listOfFields
                            .get(INSTANCE_FIELD_INDEX)
                            .split(COMMA)[FRUIT_INDEX])
                    .append(COMMA)
                    .append(getAmount(listOfFields))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private int getAmount(List<String> listOfFields) {
        int amount = 0;
        for (String string : listOfFields) {
            String action = string.split(COMMA)[ACTION_INDEX];
            int value = Integer.parseInt(string.split(COMMA)[AMOUNT_INDEX]);
            amount += actionStrategy
                    .get(Action.valueOf(action))
                    .performAction(value);
        }
        reportValidator.validate(amount);
        return amount;
    }
}
