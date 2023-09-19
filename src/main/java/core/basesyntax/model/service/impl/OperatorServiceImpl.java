package core.basesyntax.model.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.handler.OperationHandler;
import core.basesyntax.model.service.OperatorService;
import java.util.List;
import java.util.Map;

public class OperatorServiceImpl implements OperatorService {
    private Map<Operation, OperationHandler> operationMap;

    public OperatorServiceImpl(Map<Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void operateTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(transaction
                -> operationMap.get(transaction.getOperation())
                .handleOperation(transaction));
    }
}
