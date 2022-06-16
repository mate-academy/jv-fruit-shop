package core.basesyntax.strategy.activities;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.ProductTransaction;

public class SubstractActivitiesHandler implements ActivitiesHandler {
    private final ProductDao productDao;

    public SubstractActivitiesHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void process(ProductTransaction transaction) {
        Integer actualQuantity = productDao.get(transaction.getProduct())
                .orElseThrow(() -> new RuntimeException("Can`t substract "
                        + transaction.getQuantity() + " "
                        + transaction.getProduct() + " no product in the storage"));

        if (actualQuantity - transaction.getQuantity() < 0) {
            throw new RuntimeException("Can`t substract "
                    + transaction.getQuantity() + " "
                    + transaction.getProduct() + " from "
                    + actualQuantity + " units");
        }

        productDao.add(transaction.getProduct(),actualQuantity - transaction.getQuantity());
    }
}
