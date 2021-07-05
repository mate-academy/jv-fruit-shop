package core.basesyntax.service.validator;

public class ValidatorImpl implements Validator {
    private static final String WORDS_SEPARATOR = ",";
    private static final int VALUE_INDEX = 2;

    @Override
    public void validate(String string) {
        string = string.trim();
        if (!string.matches("\\w,\\w+,\\d+")) {
            throw new RuntimeException("Wrong input format " + string);
        }
    }
}
