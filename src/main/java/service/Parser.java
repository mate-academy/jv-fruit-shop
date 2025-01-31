package service;

import model.FruitTransaction;

public interface Parser {

    FruitTransaction parseTransaction(String line);
}
