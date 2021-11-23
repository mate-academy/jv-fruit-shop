package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.handler.WorkWithFruits;

public interface FruitWorkStrategy {
    WorkWithFruits get(Operation key);
}
