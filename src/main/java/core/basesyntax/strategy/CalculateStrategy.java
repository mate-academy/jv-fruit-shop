package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.HashMap;
import java.util.Map;

public interface CalculateStrategy {
    public OperationHandler getHandler(FruitTransaction transaction);
}
