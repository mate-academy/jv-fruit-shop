package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface StorageFilling {
    void addToStorage(String[] parsedData, Storage storage);
}
