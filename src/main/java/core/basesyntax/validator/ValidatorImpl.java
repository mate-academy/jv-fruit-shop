package core.basesyntax.validator;

import java.util.List;
import java.util.stream.Collectors;

public class ValidatorImpl implements Validator {
    private static final int HEAD_STRING = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int NUMBER_INDEX = 2;

    @Override
    public boolean validate(List<String> input) {
        input.remove(HEAD_STRING);
        List<String> fruits = input.stream().map(s -> s.split(","))
                .filter(strings -> strings[OPERATION_INDEX].equals("b"))
                .map(strings -> strings[FRUIT_INDEX])
                .collect(Collectors.toList());
        return !input.stream()
                .map(s -> s.split(","))
                .anyMatch(strings -> Integer.parseInt(strings[NUMBER_INDEX]) < OPERATION_INDEX
                    || (strings[OPERATION_INDEX].isEmpty()
                        || strings[FRUIT_INDEX].isEmpty()
                        || strings[NUMBER_INDEX].isEmpty())
                    || !(fruits.contains(strings[1])));
    }
}
