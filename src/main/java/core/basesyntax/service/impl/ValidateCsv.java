package core.basesyntax.service.impl;

import core.basesyntax.service.FileValidator;
import java.util.List;

public class ValidateCsv implements FileValidator {
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public boolean isValid(List<String> text) {
        if (!text.get(0).equals(HEADER)) {
            return false;
        }
        return text.stream()
                .skip(1)
                .map(s -> s.split(",").length == 3 && s.split(",")[0].length() == 1)
                .filter(b -> !b)
                .findFirst().orElse(true);
    }
}
