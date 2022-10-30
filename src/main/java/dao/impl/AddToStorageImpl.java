package dao.impl;

import dao.AddToStorage;
import db.Storage;

public class AddToStorageImpl implements AddToStorage {
    @Override
    public void writeToStorage(String fruit, Integer addNumber) {
        int newNumber = addNumber;
        if(Storage.storage.containsKey(fruit)) {
            int previousNumber = Storage.storage.get(fruit);
            newNumber = previousNumber + addNumber;
        }
        Storage.storage.put(fruit, newNumber);
    }
}
