package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public Map<String, Integer> getStorage() {
        return Storage.getStorage();
    }

    @Override
    public void proces(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            operationStrategy.getHandler(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
    }
}
