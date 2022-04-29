package strategy;

import model.Product;
import storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void operation(Product product, Integer quantity) {
        Integer initialQuantity = Storage.STORAGE.get(product);
        Storage.STORAGE.put(product,
                initialQuantity == null
                        ? quantity
                        : initialQuantity + quantity);
    }
}
