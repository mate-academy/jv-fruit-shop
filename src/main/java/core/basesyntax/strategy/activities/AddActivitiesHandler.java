package core.basesyntax.strategy.activities;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.ProductTransaction;
import java.util.Optional;

public class AddActivitiesHandler implements ActivitiesHandler {
    private final ProductDao productDao;

    public AddActivitiesHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void process(ProductTransaction transaction) {
        Optional<Integer> actualQuantity = productDao.get(transaction.getProduct());

        productDao.add(transaction.getProduct(),
                transaction.getQuantity() + actualQuantity.orElse(0));
    }
}
