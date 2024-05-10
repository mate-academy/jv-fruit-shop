package service;

import model.FruitTransaction;

public interface TransactionParserService {
    FruitTransaction parseFromString(String inputStrings);
}
