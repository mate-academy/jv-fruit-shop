package service;

import model.FruitTransaction;

import java.io.File;
import java.util.List;

public interface FileReaderService {
    List<FruitTransaction> getTransactionsFromFile(File inputFile);
    void readFile(File inputFile);
}
