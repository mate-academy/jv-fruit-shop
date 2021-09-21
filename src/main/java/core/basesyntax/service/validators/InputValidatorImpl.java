package core.basesyntax.service.validators;

import core.basesyntax.model.ActivitiesType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidatorImpl implements InputValidator {
    private static final int HEAD_STRING = 0;
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String TYPE = "type";
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String REGEX = ",";

    @Override
    public void validate(List<String> data) {
        String[] head = data.get(HEAD_STRING).split(REGEX);
        if (!head[ACTIVITY_TYPE_INDEX].equals(TYPE)
                || !head[FRUIT_INDEX].equals(FRUIT)
                || !head[AMOUNT_INDEX].equals(QUANTITY)) {
            throw new RuntimeException("input data is invalid");
        }
        List<String> dataToValidate = new ArrayList<>(List.copyOf(data));
        dataToValidate.remove(HEAD_STRING);
        List<String> fruits = dataToValidate.stream()
                .map(s -> s.split(REGEX))
                .filter(s -> s[ACTIVITY_TYPE_INDEX].equals(ActivitiesType.b.toString()))
                .map(s -> s[FRUIT_INDEX])
                .collect(Collectors.toList());
        boolean flag = dataToValidate.stream()
                .map(s -> s.split(REGEX))
                .anyMatch(s -> (s[ACTIVITY_TYPE_INDEX].isEmpty()
                    || s[FRUIT_INDEX].isEmpty()
                    || s[AMOUNT_INDEX].isEmpty())
                    || !(fruits.contains(s[FRUIT_INDEX]))
                    || Integer.parseInt(s[AMOUNT_INDEX]) < 0);
        if (flag) {
            throw new RuntimeException("input data is invalid");
        }
    }
}
