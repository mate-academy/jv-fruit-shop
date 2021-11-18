package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import core.basesyntax.service.activity.TypeActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final String HEAD = "type,fruit,quantity";
    private static final String VALID_DATA_PATTERN = "[a-z],[a-z]+,[0-9]+";

    @Override
    public boolean validateData(List<String> data) {
        List<String> dataCopy = new ArrayList<>(data);
        if (data.isEmpty() || !checkAndDeleteFirstLine(dataCopy)) {
            throw new RuntimeException("Invalid input data, try again");
        }
        Predicate<String> linePredicate = line -> Pattern.matches(VALID_DATA_PATTERN, line)
                && checkValidActivityType(TypeActivity.values(), line.charAt(ACTIVITY_TYPE_INDEX))
                && line.charAt(line.lastIndexOf(',') + 1) != '0';
        long countOfValidLines = dataCopy.stream()
                .filter(linePredicate)
                .count();
        if ((countOfValidLines + 1) != data.size()) {
            throw new RuntimeException("Invalid input data, try again");
        }
        return true;
    }

    private boolean checkAndDeleteFirstLine(List<String> data) {
        return data.get(0).equals(HEAD);
    }

    private boolean checkValidActivityType(TypeActivity[] values, char line) {
        String operation = String.valueOf(line);
        String[] activities = Arrays.toString(values).split("");
        return Arrays.asList(activities).contains(operation);
    }
}
