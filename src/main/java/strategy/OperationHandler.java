package strategy;

import model.Product;

public interface OperationHandler {
    public void operation(Product product, Integer quantity);
}
