package core.basesyntax.service.impl;

import java.util.function.Predicate;

public class ValidFirstLinePredicate implements Predicate<String> {
    private static final String INVALID_FIRST_LINE_START = "type";

    @Override
    public boolean test(String element) {
        return !element.isEmpty()
                && element.trim().toLowerCase().startsWith(INVALID_FIRST_LINE_START);
    }
}
