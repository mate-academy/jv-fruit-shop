package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler extends OperationHandler {
    public SupplyOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        isFruitValid(operation.getFruitName());
        if (operation.getAmount() < 0) {
            throw new RuntimeException("Illegal amount of fruits: " + operation.getAmount()
                    + "for fruit: " + operation.getFruitName());
        }
        int newAmount = dao.get(operation.getFruitName()) + operation.getAmount();
        dao.update(operation.getFruitName(), newAmount);
    }
}
