package service;

import model.FruitTransaction;

public interface FruitParser {
    FruitTransaction parseFruitTransaction(String line);
}
