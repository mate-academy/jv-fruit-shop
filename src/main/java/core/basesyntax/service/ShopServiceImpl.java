package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ActionStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final ActionStrategy actionStrategy;
    public ShopServiceImpl(ActionStrategy operationStrategy) {
        this.actionStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            ActionHandler handler = actionStrategy.getHandler(transaction.getAction());
            handler.apply(transaction.getFruit(), transaction.getValue());
        }
    }
}
