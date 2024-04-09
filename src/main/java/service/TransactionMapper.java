package service;

import model.FruitTransaction;

public interface TransactionMapper {
    FruitTransaction map(String dataLine);
}
