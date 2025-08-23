package core.basesyntax.typeofoperationhandler.operationservice;

import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.typeofoperationhandler.TypeOfOperationService;
import java.util.Map;

public class OperationHandlerImpl implements OperationHandler {
    private Map<TypeOfOperation, TypeOfOperationService> operationHandlerMap;

    public OperationHandlerImpl(Map<TypeOfOperation,
            TypeOfOperationService> getAdequateOperationHandler) {
        this.operationHandlerMap = getAdequateOperationHandler;
    }

    @Override
    public TypeOfOperationService getOperationHandler(TypeOfOperation typeOfOperation) {
        return operationHandlerMap.get(typeOfOperation);
    }
}
