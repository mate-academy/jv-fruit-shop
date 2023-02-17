package service;

import java.io.File;
import java.util.List;
import model.FruitTransaction;

public interface FileReaderService {

    List<FruitTransaction> getTransactionsFromFile(File inputFile);

    void readFile(File inputFile);
}
