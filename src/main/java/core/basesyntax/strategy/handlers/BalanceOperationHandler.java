package core.basesyntax.strategy.handlers;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.model.GoodsOperation;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handleOperation(GoodsOperation operation) {
        String goodsName = operation.getItem();
        Integer balance = operation.getQuantity();
        storageDao.setQuantityGoods(goodsName, balance);
    }
}
