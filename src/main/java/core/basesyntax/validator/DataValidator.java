package core.basesyntax.validator;

import java.util.List;

public class DataValidator {
    private static final String COMMA = ",";
    private static final String REGEX = "[srbp]";
    private static final int NUMBER_OF_FIELDS = 3;
    private static final int ACTION_INDEX = 0;
    private static final int AMOUNT_INDEX = 2;

    public void validate(List<String> dataFromFile) {
        int count = (int) dataFromFile.stream()
                .skip(1)
                .filter(string -> isCorrectNumberOfFields(string)
                        && isCorrectAction(string)
                        && isCorrectAmount(string))
                .count();
        if (count < dataFromFile.size() - 1) {
            throw new RuntimeException("Incorrect input data. Check the file!");
        }
    }

    private boolean isCorrectNumberOfFields(String string) {
        return string.split(COMMA).length == NUMBER_OF_FIELDS;
    }

    private boolean isCorrectAction(String string) {
        return string.split(COMMA)[ACTION_INDEX].matches(REGEX);
    }

    private boolean isCorrectAmount(String string) {
        return Integer.parseInt(string.split(COMMA)[AMOUNT_INDEX]) >= 0;
    }
}
