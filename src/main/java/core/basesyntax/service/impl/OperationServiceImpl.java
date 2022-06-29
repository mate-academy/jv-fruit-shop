package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationServiceImpl implements OperationService {
    private final Map<Transaction.Operation, OperationHandler> handlerMap;

    public OperationServiceImpl(Map<Transaction.Operation, OperationHandler> handleMap) {
        this.handlerMap = handleMap;
    }

    @Override
    public OperationHandler getHandler(Transaction.Operation typeOperation) {
        return handlerMap.get(typeOperation);
    }
}
