package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.Items;
import core.basesyntax.shop.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean test(String s) {
        return s.matches("(?si)^type,fruit,quantity(?m)"
                + "(\\n[bspr],(" + Items.getItemsForValidation() + "),\\d{1,4})+$");
    }
}
