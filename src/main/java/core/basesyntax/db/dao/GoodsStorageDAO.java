package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;

public abstract class GoodsStorageDAO implements StorageDAO {
    protected final Storage storage;

    public GoodsStorageDAO(Storage storage) {
        this.storage = storage;
    }
}
