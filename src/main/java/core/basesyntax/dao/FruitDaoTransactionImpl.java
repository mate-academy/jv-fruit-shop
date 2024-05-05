package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.StrategyHandler;
import java.util.Map;

public class FruitDaoTransactionImpl implements FruitDaoTransaction {
    private final StrategyService strategyService;

    public FruitDaoTransactionImpl(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public void updateAmount(FruitTransaction fruitTransaction) {
        StrategyHandler strategy = strategyService.getStrategy(fruitTransaction.getOperation());
        getFruitMap().put(fruitTransaction.getFruitName(), strategy.doStrategy(fruitTransaction));
    }

    @Override
    public Map<String, Integer> getFruitMap() {
        return Storage.FRUITS;
    }
}
