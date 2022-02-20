package core.basesyntax.service.strategy;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {

    private Map<String, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(
            Map<String, TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
  public TransactionHandler get(String operation) {
        return transactionHandlerMap.get(operation);
    }
}
