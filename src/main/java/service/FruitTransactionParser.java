package service;

import model.FruitTransaction;

public interface FruitTransactionParser {
    FruitTransaction parse(String line);
}
