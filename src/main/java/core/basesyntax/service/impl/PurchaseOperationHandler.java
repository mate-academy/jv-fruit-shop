package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ShopDao;
import java.util.Map;

public class PurchaseOperationHandler extends OperationHandler {
    public PurchaseOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        Map.Entry<String, Integer> shopEntry = dao.get(operation.getFruitName());
        if (shopEntry.getValue() < operation.getAmount()) {
            throw new RuntimeException("Not enough fruits");
        }
        int newAmount = shopEntry.getValue() - operation.getAmount();
        dao.update(operation.getFruitName(), newAmount);
    }
}
