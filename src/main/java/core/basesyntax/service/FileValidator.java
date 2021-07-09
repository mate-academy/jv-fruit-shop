package core.basesyntax.service;

public class FileValidator implements Validator {
    private static final String REGEX = "[bspr],[a-z]+,\\d+";

    @Override
    public void validate(String line) {
        if (!line.matches(REGEX)) {
            throw new RuntimeException("Incorrect input data! Error in line: " + line);
        }
    }
}
