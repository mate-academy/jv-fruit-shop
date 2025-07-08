package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.stream()
                .forEach(t -> operationStrategy.get(t).operate(t));
    }
}
