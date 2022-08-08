package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class StrategyOperationImpl implements StrategyOperation {
    private final Map<Transaction.Type, OperationHandler> typeTransactionMap;

    public StrategyOperationImpl(Map<Transaction.Type, OperationHandler> typeOperationMap) {
        this.typeTransactionMap = typeOperationMap;
    }

    @Override
    public OperationHandler getOperationHandler(Transaction.Type typeOperation) {
        return typeTransactionMap.get(typeOperation);
    }
}
