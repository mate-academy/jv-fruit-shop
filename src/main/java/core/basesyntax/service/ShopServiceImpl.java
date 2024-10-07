package core.basesyntax.service;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Inventory inventory;

    public ShopServiceImpl(OperationStrategy operationStrategy, Inventory inventory) {
        this.operationStrategy = operationStrategy;
        this.inventory = inventory;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getHandler(fruitTransaction, inventory);
        }
    }
}
