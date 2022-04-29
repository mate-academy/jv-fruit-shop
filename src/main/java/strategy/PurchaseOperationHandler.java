package strategy;

import model.Product;
import storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operation(Product product, Integer quantity) {
        Integer initialQuantity = Storage.STORAGE.get(product);
        if (Storage.STORAGE.get(product) == null) {
            throw new RuntimeException("Null");
        }
        if (Storage.STORAGE.get(product) - quantity < 0) {
            throw new RuntimeException("Not enough of " + product + "'s");
        }
        Storage.STORAGE.put(product, initialQuantity - quantity);
    }
}
