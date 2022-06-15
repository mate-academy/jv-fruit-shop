package core.basesyntax.strategy;

import core.basesyntax.service.transaction.TransactionHandler;
import java.util.Map;

public class TransactionsStrategyImpl implements TransactionsStrategy {
    private Map<String, TransactionHandler> operationMap;

    public TransactionsStrategyImpl(Map<String, TransactionHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public TransactionHandler get(String dataFromFile) {
        return operationMap.get(dataFromFile);
    }
}
