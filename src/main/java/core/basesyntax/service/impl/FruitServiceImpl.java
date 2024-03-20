package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private Storage storage;

    public FruitServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void manipulation(String nameFruit, int quantity) {
        storage.addFruit(nameFruit, quantity);
    }
}
