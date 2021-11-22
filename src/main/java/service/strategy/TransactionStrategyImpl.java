package service.strategy;

import java.util.List;
import java.util.Map;
import model.Operation;
import model.Transaction;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public TransactionStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void execute(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = operationHandlerMap.get(transaction.getOperation());
            handler.execute(transaction);
        }
    }
}
