package service;

import model.FruitTransaction;

public interface InventoryDao {
    boolean addToStorage(FruitTransaction operation);

}
