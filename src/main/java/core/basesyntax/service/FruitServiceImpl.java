package core.basesyntax.service;

import core.basesyntax.dto.OperationType;
import core.basesyntax.dto.Transaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public void addTransaction(Map<OperationType, OperationHandler> handlerMap,
                               List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            OperationHandler operationHandler = handlerMap.get(transaction.getOperationType());
            operationHandler.apply(transaction);
        }
    }
}
