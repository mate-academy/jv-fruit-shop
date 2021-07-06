package core.basesyntax.service;

import java.util.List;

public class FileValidator implements Validator {
    private static final String REGEX = "[bspr],[a-z]+,\\d+";

    @Override
    public void validate(List<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            if (!lines.get(i).matches(REGEX)) {
                throw new RuntimeException("Incorrect input data! Error in line: " + lines.get(i));
            }
        }
    }
}
