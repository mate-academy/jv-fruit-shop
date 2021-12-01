package core.basesyntax.service.validator;

public class ValidatorImpl implements Validator {
    private static final String LINE_MATCHER_REGEX = "[bspr],\\w+,\\d+";

    @Override
    public boolean isValid(String line) {
        return line.matches(LINE_MATCHER_REGEX);
    }
}
