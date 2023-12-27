package core.basesyntax.strategy.handlers;

import core.basesyntax.constants.Product;

public interface ActivityHandler {
    public void updateProductInfo(Product product, Integer amount);
}
