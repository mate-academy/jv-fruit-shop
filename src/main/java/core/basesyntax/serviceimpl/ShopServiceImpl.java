package core.basesyntax.serviceimpl;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final Strategy strategy;
    private final Inventory inventory;

    public ShopServiceImpl(Strategy strategy, Inventory inventory) {
        this.strategy = strategy;
        this.inventory = inventory;
    }

    @Override
    public void process(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getOperationHandler(transaction.getOperation());
            handler.handle(transaction, inventory);
        }
    }
}
