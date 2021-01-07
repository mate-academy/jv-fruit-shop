package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class OperationHandlerImpl implements OperationHandler {
    private Map<Operation, OperationStrategy> strategyMap;

    public OperationHandlerImpl(Map<Operation, OperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void executeTransaction(List<TransactionDto> transactions) {
        transactions.forEach(t -> strategyMap.get(t.getOperation()).apply(t));
    }

}
