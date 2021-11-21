package core.basesyntax.strategy;

import core.basesyntax.service.handler.WorkWithFruits;

public interface FruitWorkStrategy {
    WorkWithFruits get(String key);
}
