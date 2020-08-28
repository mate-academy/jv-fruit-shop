package core.basesyntax.operations;

import core.basesyntax.dao.Storage;
import core.basesyntax.goods.Product;

public interface Operation {

    boolean updateStorage(Product product, Storage storage);
}
