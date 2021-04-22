package core.basesyntax.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.Product;

public interface Operation {
    void perform(Product fruit, int amount, ProductDao productDao);
}
