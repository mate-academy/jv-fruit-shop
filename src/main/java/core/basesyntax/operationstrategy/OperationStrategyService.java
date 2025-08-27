package core.basesyntax.operationstrategy;

import core.basesyntax.fruittransactionhandler.OperationHandler;
import core.basesyntax.model.TypeOfTransaction;

public interface OperationStrategyService {
    OperationHandler getHandler(TypeOfTransaction typeOfTransaction);
}
