package dao.impl;

import dao.IsInStorage;
import db.Storage;

public class TestOfPresent implements IsInStorage {
    @Override
    public boolean isInStorage(String fruit) {
        return Storage.storage.containsKey(fruit);
    }
}
