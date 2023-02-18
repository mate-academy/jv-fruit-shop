package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.List;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<Operation, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<Operation, TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public void processTransaction(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            get(transaction.getOperation()).makeTransaction(transaction);
        }
    }

    @Override
    public TransactionHandler get(Operation operation) {
        return transactionHandlerMap.get(operation);
    }

}
