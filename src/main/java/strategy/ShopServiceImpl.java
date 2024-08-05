package strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storage = new Storage();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation());
        }
    }
}
