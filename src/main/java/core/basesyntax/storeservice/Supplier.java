package core.basesyntax.storeservice;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.dao.Storage;
import core.basesyntax.goods.FruitPack;

public class Supplier implements Operation {
    private final FruitStorage storage;

    public Supplier() {
        this.storage = Storage.MAIN_STORAGE;
    }

    @Override
    public boolean updateStorage(FruitPack product) {
        storage.addProduct(product);
        return true;
    }
}
