package core.basesyntax.service;

import core.basesyntax.stoage.Storage;

public class StorageServiceImpl implements StorageService {
    @Override
    public void addToStorage(String aboutProduct) {
        String[] newProduct = aboutProduct.split(",");
        Storage.storage.put(newProduct[0], Integer.valueOf(newProduct[1]));
    }

    @Override
    public Integer getFromStorage(String fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public void setValue(String fruit, Integer setValue) {
        Storage.storage.remove(fruit);
        Storage.storage.put(fruit,setValue);
    }
}
