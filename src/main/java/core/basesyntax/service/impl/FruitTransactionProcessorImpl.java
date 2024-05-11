package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.StrategyHandler;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final StrategyService strategyService;

    public FruitTransactionProcessorImpl(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public void fillStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            StrategyHandler strategy =
                    strategyService.getStrategy(fruitTransaction.getOperation());
            strategy.handle(fruitTransaction);
        }
    }
}
