package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final Strategy strategy;

    public FruitServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        data.forEach(c -> {
            OperationProcessor service =
                    strategy.get(c.getOperation());
            service.process(c);
        });
    }
}
