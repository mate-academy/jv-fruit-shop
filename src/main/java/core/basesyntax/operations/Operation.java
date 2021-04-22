package core.basesyntax.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.Product;

public interface Operation {
    int calculateAmount(int oldAmount, int amount);
}
