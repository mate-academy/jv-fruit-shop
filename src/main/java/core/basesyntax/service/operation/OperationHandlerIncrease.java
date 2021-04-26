package core.basesyntax.service.operation;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.Product;
import core.basesyntax.storage.Storage;
import java.util.Optional;

public class OperationHandlerIncrease implements OperationHandler {
    private final ProductDao productDao;

    public OperationHandlerIncrease(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public int apply(int amount, Product key) {
        Optional<Integer> fruitQuantity = productDao.get(key);
        if (fruitQuantity.isPresent()) {
            int currentAmount = Storage.productStorage.get(key);
            return currentAmount + amount;
        }
        return amount;
    }
}
