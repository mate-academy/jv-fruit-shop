package service;

import model.FruitTransaction;

import java.util.List;

public interface FruitTransactionConverter {
    List<FruitTransaction> convertToFruitTransaction(List<String> inputData);
}
