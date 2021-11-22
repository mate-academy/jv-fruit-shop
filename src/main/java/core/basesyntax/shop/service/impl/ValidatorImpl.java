package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean test(String s) {
        return s.matches("(?si)^type,fruit,quantity(?m)"
                + "(\\n[bspr],(banana|apple|pear),\\d{1,4})+$");
    }
}
