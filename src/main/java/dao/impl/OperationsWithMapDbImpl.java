package dao.impl;

import dao.OperationsWithMapDb;
import db.Storage;

public class OperationsWithMapDbImpl implements OperationsWithMapDb {
    private static final String EXCEPTION_MESSAGE = "There is no such fruit in the storage!";

    @Override
    public void writeToStorage(String fruit, Integer number) {
        int newNumber = number;
        if (Storage.storage.containsKey(fruit)) {
            int previousNumber = Storage.storage.get(fruit);
            newNumber = previousNumber + number;
        }
        Storage.storage.put(fruit, newNumber);
    }

    @Override
    public boolean isInStorage(String fruit) {
        return Storage.storage.containsKey(fruit);
    }

    @Override
    public void subtrackFromStorage(String fruit, Integer subtractNumber) {
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        int previousNumber = Storage.storage.get(fruit);
        int newNumber = previousNumber - subtractNumber;
        Storage.storage.put(fruit, newNumber);

    }
}
