package core.basesyntax.validator;

import java.util.List;

public class DataValidator {
    private static final String COMMA = ",";
    private static final int NUMBER_OF_FIELDS = 3;
    private static final int ACTION_INDEX = 0;

    public void validate(List<String> dataFromFile) {
        int count = (int) dataFromFile.stream()
                .skip(1)
                .filter(string -> string
                        .split(COMMA).length == NUMBER_OF_FIELDS
                        && string.split(COMMA)[ACTION_INDEX]
                        .matches("[srbp]"))
                .count();
        if (count < dataFromFile.size() - 1) {
            throw new RuntimeException("Incorrect input data. Check the file!");
        }
    }
}
