package core.basesyntax;

import java.util.List;

class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void process(List<FruitTransaction> transactions) {
        operationStrategy.process(transactions);
    }
}
