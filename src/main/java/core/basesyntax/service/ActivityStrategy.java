package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(FruitTransaction.ACTIVITY activity);
}
