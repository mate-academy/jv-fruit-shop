package core.basesyntax.storeservice;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.dao.Storage;
import core.basesyntax.goods.FruitPack;

public class Consumer implements Operation {
    private FruitStorage storage;

    public Consumer() {
        this.storage = Storage.MAIN_STORAGE;
    }

    @Override
    public boolean updateStorage(FruitPack product) {
        storage.getBox(product.getType()).takeProduct(product);
        return true;
    }
}
