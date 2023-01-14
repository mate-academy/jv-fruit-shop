package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransition;
import core.basesyntax.service.TransitionService;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class TransitionServiceImpl implements TransitionService {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public TransitionServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void doTransition(List<FruitTransition> fruitTransitionList) {
        for (FruitTransition transition : fruitTransitionList) {
            if (!FruitStorage.storage.containsKey(transition.getFruit())) {
                FruitStorage.storage.put(transition.getFruit(), transition.getCount());
            } else {
                FruitStorage.storage.put(transition.getFruit(),
                        operationHandlerStrategy.get(transition.getOperation())
                                .apply(FruitStorage.storage.get(transition.getFruit()),
                                        transition.getCount()));
            }
        }
    }
}
