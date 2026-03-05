package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public class ShopService {

    private final OperationStrategy strategy;

    public ShopService(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction tx : transactions) {
            OperationHandler handler = strategy.getHandlers(tx.getOperation());
            handler.apply(tx);
        }
    }
}