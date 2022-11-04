package core.basesyntax.servises.impl;

import core.basesyntax.models.FruitTransition;
import core.basesyntax.servises.FruitService;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private Strategy strategy;

    public FruitServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doOperationService(List<FruitTransition> list) {
        list.stream().forEach(i -> strategy.get(i.getOperation())
                .doOperation(i));
    }
}
