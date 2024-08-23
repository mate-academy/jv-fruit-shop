package core.basesyntax.storage;

import core.basesyntax.storage.impl.StorageEntry;

import java.util.Collection;

public interface Storage {
    Collection<StorageEntry> getAllEntries();
    void updateEntry(String product, int quantity);
    StorageEntry getProductQuantity(String product);
}
