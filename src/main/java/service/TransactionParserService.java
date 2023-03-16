package service;

import model.FruitTransaction;

public interface TransactionParserService {
    //void saveToStorage(List<String> list);
    FruitTransaction saveToStorage(String line);
}
