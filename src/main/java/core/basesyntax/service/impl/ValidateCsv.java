package core.basesyntax.service.impl;

import core.basesyntax.service.FileValidator;
import java.util.List;
import java.util.Optional;

public class ValidateCsv implements FileValidator {
    private static final String HEADER = "type,fruit,quantity";
    private static final int HEADER_POSITION = 0;
    private static final int OPERATION_POSITION = 0;
    private static final int HEADER_LINES_LENGTH = 1;
    private static final int NORMAL_ARRAY_LENGTH = 3;
    private static final int ABBREVIATION_LENGTH = 1;
    private static final String SEPARATOR = ",";

    @Override
    public boolean isValid(List<String> text) {
        if (!text.get(HEADER_POSITION).equals(HEADER)) {
            return false;
        }
        Optional<Boolean> validationResult = text.stream()
                .skip(HEADER_LINES_LENGTH)
                .map(s -> s.split(SEPARATOR).length == NORMAL_ARRAY_LENGTH
                        && s.split(SEPARATOR)[OPERATION_POSITION].length() == ABBREVIATION_LENGTH)
                .filter(b -> !b)
                .findAny();
        if (!validationResult.orElse(true)) {
            throw new RuntimeException("input data from file"
                    + " has unsupported format");
        }
        return true;
    }
}
