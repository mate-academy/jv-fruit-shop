package core.basesyntax.strategy;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.operationhadler.TransactionHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitsTransaction.Operation, TransactionHandler> fruitsMap;

    public StrategyImpl(Map<FruitsTransaction.Operation, TransactionHandler> fruitsMap) {
        this.fruitsMap = fruitsMap;
    }

    @Override
    public TransactionHandler getOperationHandler(FruitsTransaction.Operation operation) {
        return fruitsMap.get(operation);
    }
}

