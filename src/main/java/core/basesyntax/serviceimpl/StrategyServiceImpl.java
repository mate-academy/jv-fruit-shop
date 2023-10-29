package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService {
    private Map<Operation, OperationHandler> actionHashMap;

    public StrategyServiceImpl(Map<Operation, OperationHandler> actionHashMap) {
        this.actionHashMap = actionHashMap;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> actionHashMap.get(t.getName()).processOperation(t));
    }
}
