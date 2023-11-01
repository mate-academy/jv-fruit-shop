package core.basesyntax.strategy.handlers;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.model.GoodsOperation;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handleOperation(GoodsOperation operation) {
        String goodsName = operation.getItem();
        Integer itemStock = storageDao.getQuantityGoods(goodsName);
        Integer newQuantity = itemStock + operation.getQuantity();
        storageDao.setQuantityGoods(goodsName, newQuantity);
    }
}
