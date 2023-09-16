package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationName;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService {
    @Override
    public void processTransactions(Map<OperationName, OperationHandler> actionHashMap,
                                    List<FruitTransaction> transactions) {
        transactions.forEach(t -> actionHashMap.get(t.getName()).processOperation(t));
    }
}
