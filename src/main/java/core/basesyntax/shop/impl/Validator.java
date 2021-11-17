package core.basesyntax.shop.impl;

import java.util.function.Predicate;

public class Validator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.matches("(?si)^type,fruit,quantity+(?m)" +
                "(\\n[bspr],(banana|apple|pear),\\d{1,4})+$");
    }
}
