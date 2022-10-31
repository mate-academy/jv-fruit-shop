package dao.impl;

import dao.SubtackFromStorage;
import db.Storage;

public class SubstrackFromStorageImpl implements SubtackFromStorage {
    @Override
    public void subtrackFromStorage(String fruit, Integer subtractNumber) {
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException("There is no such fruit in the storage!");
        }
        int previousNumber = Storage.storage.get(fruit);
        int newNumber = previousNumber - subtractNumber;
        Storage.storage.put(fruit, newNumber);
    }
}
