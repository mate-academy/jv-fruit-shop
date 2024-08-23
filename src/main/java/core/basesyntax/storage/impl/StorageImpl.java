package core.basesyntax.storage.impl;

import core.basesyntax.storage.Storage;

import java.util.Collection;
import java.util.HashMap;

public class StorageImpl implements Storage {
    private final HashMap<String, StorageEntry> entries;

    public StorageImpl(HashMap<String, StorageEntry> entries) {
        this.entries = entries;
    }
    public StorageImpl() { this.entries = new HashMap<>(); }

    @Override
    public Collection<StorageEntry> getAllEntries() {
        return this.entries.values();
    }

    @Override
    public void updateEntry(String product, int quantity) {
        StorageEntry current = entries.get(product);
        if (current == null) {
            StorageEntry newEntry = new StorageEntry(product, quantity);
            entries.put(product, newEntry);
        } else {
            current.setQuantity(current.getQuantity() + quantity);
        }
    }

    @Override
    public StorageEntry getProductQuantity(String product) {
        return entries.get(product);
    }
}
