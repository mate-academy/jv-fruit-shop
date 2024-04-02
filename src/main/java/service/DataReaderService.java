package service;

import model.FruitTransaction;

import java.util.List;

public interface DataReaderService {
    List<FruitTransaction> readDataInFile(String filePath);
}
