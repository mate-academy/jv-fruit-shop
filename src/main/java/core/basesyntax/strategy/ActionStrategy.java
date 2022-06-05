package core.basesyntax.strategy;

import core.basesyntax.model.ProductTransaction;
import core.basesyntax.strategy.action.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(ProductTransaction.Operation operation);
}
