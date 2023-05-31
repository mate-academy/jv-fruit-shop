package strategy.handlerimpl;

import dao.StorageDao;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer operate(FruitTransaction order, StorageDao inStock) {
        int quantityInStock = inStock.get(order.getFruit());
        int quantityToReturn = order.getQuantity();
        return quantityInStock + quantityToReturn;
    }
}
