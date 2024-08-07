package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationExecutor {
    void proceedAll(List<FruitTransaction> commands);
}
