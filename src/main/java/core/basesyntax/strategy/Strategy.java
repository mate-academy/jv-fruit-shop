package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.CalculateOperation;

public interface Strategy {
    CalculateOperation get(FruitOperation.Operation operation);
}
