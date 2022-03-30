package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy<TransactionDto> {
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void calculateTransactions(List<TransactionDto> transactions) {
        for (TransactionDto transaction : transactions) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction.getName(), transaction.getQuantity());
        }
    }
}
