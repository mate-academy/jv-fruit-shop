package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import core.basesyntax.service.activity.ActivityHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final java.lang.String INPUT_DATA_HEAD = "type,fruit,quantity";
    private static final java.lang.String LINE_PATTERN = "[a-z],[a-z]+,[0-9]+";
    private final Map<String, ActivityHandler> activityHandlerMap;

    public ValidatorImpl(Map<String, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public boolean validateData(List<java.lang.String> inputData) {
        List<java.lang.String> dataCopy = new ArrayList<>(inputData);
        if (inputData.isEmpty() || !dataCopy.get(0).equals(INPUT_DATA_HEAD)) {
            throw new RuntimeException("Invalid input data, try again");
        }
        Predicate<java.lang.String> linePredicate = line -> Pattern.matches(LINE_PATTERN, line)
                && activityHandlerMap.containsKey(String.valueOf(line.charAt(ACTIVITY_TYPE_INDEX)))
                && line.charAt(line.lastIndexOf(',') + 1) != '0';
        long countOfValidLines = dataCopy.stream()
                .filter(linePredicate)
                .count();
        if ((countOfValidLines + 1) != inputData.size()) {
            throw new RuntimeException("Invalid input data, try again");
        }
        return true;
    }
}
