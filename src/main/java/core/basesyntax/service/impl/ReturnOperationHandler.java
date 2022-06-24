package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ShopDao;
import java.util.Map;

public class ReturnOperationHandler extends OperationHandler {
    public ReturnOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        if (operation.getAmount() < 0) {
            throw new RuntimeException("Illegal amount of fruits");
        }
        Map.Entry<String, Integer> entry = dao.get(operation.getFruitName());
        int newAmount = entry.getValue() + operation.getAmount();
        dao.update(operation.getFruitName(), newAmount);
    }
}
