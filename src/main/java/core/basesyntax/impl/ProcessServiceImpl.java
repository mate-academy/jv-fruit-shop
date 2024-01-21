package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class ProcessServiceImpl implements ProcessService {
    private final Strategy strategy;

    public ProcessServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction: fruitTransactions) {
            strategy.get(fruitTransaction.getOperation())
                    .processOperation(fruitTransaction);
        }
    }
}
