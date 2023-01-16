package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationHandler {
    void handle(List<FruitTransaction> balanceList);
}
