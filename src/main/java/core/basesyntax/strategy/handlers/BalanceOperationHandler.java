package core.basesyntax.strategy.handlers;

import core.basesyntax.model.Operation;
import core.basesyntax.dao.ShopDao;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler extends OperationHandler {
    public BalanceOperationHandler(ShopDao dao) {
        super(dao);
    }

    @Override
    public void process(Operation operation) {
        if (dao.getAll().containsKey(operation.getFruitName())) {
            throw new RuntimeException("We couldn't process 2 balance for the same fruit");
        }
        dao.update(operation.getFruitName(), operation.getAmount());
    }
}
