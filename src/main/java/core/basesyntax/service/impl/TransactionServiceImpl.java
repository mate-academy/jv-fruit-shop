package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.transaction.OperationHandler;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public TransactionServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationMap) {
        this. operationMap = operationMap;
    }

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        operationMap.get(fruitTransaction.getOperation()).handle(
                fruitTransaction.getFruit(), fruitTransaction.getQuantity()
        );
    }

}
