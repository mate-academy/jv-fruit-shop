package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ShopDao;

public class BalanceOperationHandler extends OperationHandler {
    public BalanceOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        dao.update(operation.getFruitName(), operation.getAmount());
    }
}
