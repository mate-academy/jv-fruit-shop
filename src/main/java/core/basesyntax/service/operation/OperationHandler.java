package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.ResultData;

public interface OperationHandler {
    ResultData handle(FruitTransaction transaction);
}
