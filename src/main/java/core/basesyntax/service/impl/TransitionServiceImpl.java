package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class TransitionServiceImpl implements FruitTransactionService {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public TransitionServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransitionList) {
        for (FruitTransaction transition : fruitTransitionList) {
            if (!FruitStorage.storage.containsKey(transition.getFruit())) {
                FruitStorage.storage.put(transition.getFruit(), transition.getCount());
            } else {
                FruitStorage.storage.put(transition.getFruit(),
                        operationHandlerStrategy.get(transition.getOperation())
                                .handle(FruitStorage.storage.get(transition.getFruit()),
                                        transition.getCount()));
            }
        }
    }
}
