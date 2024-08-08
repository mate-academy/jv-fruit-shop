package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface OperationExecutor {
    void proceedAll(List<FruitOperation> commands);
}
