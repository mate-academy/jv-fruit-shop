package core.basesyntax.operations;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;

public interface Operation {

    boolean updateStorage(Product fruit, Storage storage);
}
