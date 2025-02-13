package core.basesyntax.servises;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final FruitStorage fruitStorage = new FruitStorage();
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(fruit -> operationStrategy.strategy(fruit, fruitStorage));
    }
}
