package core.basesyntax.service.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validate(Activity activity) {
        return activity.getActivityType() != null
                && activity.getFruit() != null
                && activity.getQuantity() != 0;
    }
}
