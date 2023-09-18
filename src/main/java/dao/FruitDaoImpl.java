package dao;

import database.Storage;
import exception.InvalidDataException;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, Integer quantity) {
        Storage.FRUIT_DTOS.put(fruitName, quantity);
    }

    @Override
    public Integer get(String fruitName) {
        if (Storage.FRUIT_DTOS.containsKey(fruitName)) {
            return Storage.FRUIT_DTOS.get(fruitName);
        }
        throw new InvalidDataException("No such fruit (' " + fruitName + " in the storage");
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.FRUIT_DTOS;
    }

    /*@Override
    public void add(String) {
        Storage.FRUIT_DTOS.put(fruitTransaction.getName(), fruitTransaction.getQuantity());
    }

    @Override
    public Integer get(FruitTransaction fruitTransaction) {
        if (Storage.FRUIT_DTOS.containsKey(fruitTransaction.getName())) {
            return Storage.FRUIT_DTOS.get(fruitTransaction.getName());
        }
        throw new InvalidDataException(
                "There is no fruit with name: " + fruitTransaction.getName());
    }*/
}

