package fruitshop.service.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.service.ShopService;
import fruitshop.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public OperationStrategy getOperationStrategy() {
        return operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction fruit : transactions) {
            operationStrategy.getOperation(fruit);
        }
    }
}
