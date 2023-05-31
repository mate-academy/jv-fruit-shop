package strategy.handlerimpl;

import dao.StorageDao;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer operate(FruitTransaction order, StorageDao inStock) {
        int quantityInStock = inStock.get(order.getFruit());
        int quantityToPurchase = order.getQuantity();
        if (quantityToPurchase > quantityInStock) {
            throw new RuntimeException(
                    (quantityInStock - quantityToPurchase) + " fruits not enough");
        }
        return quantityInStock - quantityToPurchase;
    }
}
