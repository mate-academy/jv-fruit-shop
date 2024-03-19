package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationStrategy {
    List<OperationHandler> getHandlers(FruitTransaction transaction);
}
