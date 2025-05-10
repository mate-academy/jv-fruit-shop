package service;

import model.FruitTransaction;

public interface FruitTransactionMapper {
    FruitTransaction[] buildFruitTransactions(String fileData);
}
