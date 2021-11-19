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
    private static final String HEAD = "type,fruit,quantity";
    private static final String VALID_DATA_PATTERN = "[a-z],[a-z]+,[0-9]+";
    private final Map<String, ActivityHandler> activityHandlerMap;

    public ValidatorImpl(Map<String, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public boolean validateData(List<String> inputData) {
        List<String> dataCopy = new ArrayList<>(inputData);
        if (inputData.isEmpty() || !checkAndDeleteFirstLine(dataCopy)) {
            throw new RuntimeException("Invalid input data, try again");
        }
        Predicate<String> linePredicate = line -> Pattern.matches(VALID_DATA_PATTERN, line)
                && activityHandlerMap.containsKey(String.valueOf(line.charAt(ACTIVITY_TYPE_INDEX)))
                && Integer.parseInt(line.substring(line.lastIndexOf(',') + 1)) >= 0;
        long countOfValidLines = dataCopy.stream()
                .filter(linePredicate)
                .count();
        if ((countOfValidLines + 1) != inputData.size()) {
            throw new RuntimeException("Invalid input data, try again");
        }
        return true;
    }

    private boolean checkAndDeleteFirstLine(List<String> data) {
        return data.get(0).equals(HEAD);
    }
}
