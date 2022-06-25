package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler extends OperationHandler {
    public PurchaseOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        isFruitValid(operation.getFruitName());
        int amount = dao.get(operation.getFruitName());
        if (amount < operation.getAmount()) {
            throw new RuntimeException("Not enough fruits for fruit: " + operation.getFruitName()
                    + " with actual amount: " + amount + " and required amount: "
                    + operation.getAmount());
        }
        int newAmount = amount - operation.getAmount();
        dao.update(operation.getFruitName(), newAmount);
    }
}
