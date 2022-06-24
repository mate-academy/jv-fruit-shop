package core.basesyntax.strategy.handlers;

import core.basesyntax.model.Operation;
import core.basesyntax.dao.ShopDao;
import core.basesyntax.strategy.OperationHandler;

import java.util.Map;

public class PurchaseOperationHandler extends OperationHandler {
    public PurchaseOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        int amount = dao.get(operation.getFruitName());
        if (amount < operation.getAmount()) {
            throw new RuntimeException("Not enough fruits");
        }
        int newAmount = amount - operation.getAmount();
        dao.update(operation.getFruitName(), newAmount);
    }
}
