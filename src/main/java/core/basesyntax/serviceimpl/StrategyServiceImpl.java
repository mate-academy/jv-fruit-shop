package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationName;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.Action;
import java.util.List;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService {
    @Override
    public void processTransactions(Map<OperationName, Action> actionHashMap,
                                    List<FruitTransaction> transactions) {
        transactions.forEach(t -> actionHashMap.get(t.getName()).action(t));
    }
}
