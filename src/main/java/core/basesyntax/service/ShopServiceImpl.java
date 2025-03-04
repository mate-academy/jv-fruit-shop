package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private ShopInventory shopInventory;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.shopInventory = new ShopInventory();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation())
                    .handle(transaction, shopInventory);
        }
    }

    @Override
    public ShopInventory getInventory() {
        return shopInventory;
    }
}
