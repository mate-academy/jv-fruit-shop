package service;

import model.FruitTransaction;

public interface ShopService {
    boolean addTransaction(FruitTransaction fruitTransaction);

    boolean getReport();
}
