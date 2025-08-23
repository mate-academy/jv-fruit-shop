package core.basesyntax.typeofoperationhandler.operationservice;

import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.typeofoperationhandler.TypeOfOperationService;

public interface OperationHandler {
    default TypeOfOperationService getOperationHandler(TypeOfOperation typeOfOperation) {
        return null;
    }
}
