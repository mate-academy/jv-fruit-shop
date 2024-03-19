package core.basesyntax.service.strategy;

import core.basesyntax.utility.FruitTransaction;

public interface ActivityService {
    int execute(FruitTransaction transaction);
}
