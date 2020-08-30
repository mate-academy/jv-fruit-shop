package core.basesyntax.storeservice;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.FruitStorage;
import core.basesyntax.dao.Storage;
import core.basesyntax.goods.FruitPack;

public class Consumer implements Operation {
    private final FruitStorage storage;

    public Consumer() {
        this.storage = Storage.MAIN_STORAGE;
    }

    @Override
    public boolean updateStorage(FruitPack product) {
        FruitPack.isPresent(product);
        final String type = product.getType();
        if (!storage.contains(type)) {
            throw new IllegalArgumentException("Invalid input arguments");
        }
        Box box = storage.getBox(type);
        box.takeProduct(product);
        if (box.isEmpty()) {
            storage.removeBox(type);
        }
        return true;
    }
}
