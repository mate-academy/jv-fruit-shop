package strategy.handlerimpl;

import dao.StorageDao;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer operate(FruitTransaction order, StorageDao inStock) {
        return inStock.get(order.getFruit());
    }
}
