package core.basesyntax.service;

import java.util.function.Predicate;

public class NonNegativePredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        if (integer < 0) {
            throw new IllegalArgumentException("Operation value cannot be negative");
        }
        return true;
    }
}
