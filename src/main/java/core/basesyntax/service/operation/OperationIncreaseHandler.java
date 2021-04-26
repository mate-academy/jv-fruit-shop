package core.basesyntax.service.operation;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.Product;
import java.util.Optional;

public class OperationIncreaseHandler implements OperationHandler {
    private final ProductDao productDao;

    public OperationIncreaseHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public int apply(int amount, Product key) {
        Optional<Integer> fruitQuantity = productDao.get(key);
        return fruitQuantity.isPresent() ? fruitQuantity.get() + amount : amount;
    }
}
