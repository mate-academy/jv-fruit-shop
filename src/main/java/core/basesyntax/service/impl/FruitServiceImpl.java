package core.basesyntax.service.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<OperationType, OperationHandler> handlerMap;

    public FruitServiceImpl(Map<OperationType, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void applyOperations(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            OperationHandler operationHandler = handlerMap.get(transaction.getOperationType());
            operationHandler.apply(transaction);
        }
    }
}
