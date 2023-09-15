package service;

import model.FruitTransaction;

public interface FruitService {
    FruitTransaction createNewFruit(String name, int quantity);
}
