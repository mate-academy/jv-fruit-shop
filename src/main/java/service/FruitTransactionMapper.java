package service;

import model.FruitTransaction;

public interface FruitTransactionMapper {
    FruitTransaction[] toFruitTransactions(String fileData);
}
