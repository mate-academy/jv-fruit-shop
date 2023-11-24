package service;

import model.FruitTransactionStorage;

public interface FileReader {
    FruitTransactionStorage read(String inputFileName);
}
