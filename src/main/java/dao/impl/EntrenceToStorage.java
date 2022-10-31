package dao.impl;

import dao.StorageEnternce;
import db.Storage;
import java.util.Map;

public class EntrenceToStorage implements StorageEnternce {
    @Override
    public Map<String, Integer> getStorage() {
        return Storage.storage;
    }
}
