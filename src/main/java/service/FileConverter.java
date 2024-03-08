package service;

import model.FruitTransaction;

public interface FileConverter {
    FruitTransaction[] convertToFruitTransactions(String fileData);
}
