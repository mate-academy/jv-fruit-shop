package core.basesyntax.service.impl;

import core.basesyntax.service.FileValidator;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateCsv implements FileValidator {
    private static final String HEADER = "type,fruit,quantity";
    private static final int NORMAL_ARRAY_LENGTH = 3;
    private static final int ABBREVIATION_LENGTH = 1;
    private static final String SEPARATOR = ",";

    @Override
    public boolean isValid(List<String> text) {
        if (!text.get(0).equals(HEADER)) {
            return false;
        }
        List<Boolean> validationResult = text.stream()
                .skip(1)
                .map(s -> s.split(SEPARATOR).length == NORMAL_ARRAY_LENGTH
                        && s.split(SEPARATOR)[0].length() == ABBREVIATION_LENGTH)
                .filter(b -> !b)
                .collect(Collectors.toList());
        if (validationResult.contains(false)) {
            throw new RuntimeException("input data from file"
                    + " has unsupported format");
        }
        return true;
    }
}
