package core.basesyntax.strategy.handlers;

import core.basesyntax.model.Operation;
import core.basesyntax.dao.ShopDao;
import core.basesyntax.strategy.OperationHandler;

import java.util.Map;

public class ReturnOperationHandler extends OperationHandler {
    public ReturnOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        isFruitValid(operation.getFruitName());
        if (operation.getAmount() < 0) {
            throw new RuntimeException("Illegal amount of fruits");
        }
        int newAmount = dao.get(operation.getFruitName()) + operation.getAmount();
        dao.update(operation.getFruitName(), newAmount);
    }
}
