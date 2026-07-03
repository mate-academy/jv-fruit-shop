package core.service;

import core.model.FruitTransaction;
import core.strategy.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transaction) {
        for (FruitTransaction trans : transaction) {
            OperationHandler handler = operationStrategy.get(trans.getOperation());
            handler.process(trans);
        }
    }
}
