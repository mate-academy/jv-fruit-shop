package core.basesyntax.service;

public class ValidatorCsv implements Validator {
    public static final String PATTERN_ELEMENT_CSV = "[bspr],\\w+,\\d+";

    @Override
    public boolean test(String o) {
        return o.matches(PATTERN_ELEMENT_CSV);
    }
}
