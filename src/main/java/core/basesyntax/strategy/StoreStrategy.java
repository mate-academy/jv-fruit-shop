package core.basesyntax.strategy;

import core.basesyntax.service.activities.Handler;

public interface StoreStrategy {
    Handler get(String letter);
}
