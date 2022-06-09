package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface LeftoversHandler {
    String getLeftovers(List<FruitTransaction> transactions);
}
