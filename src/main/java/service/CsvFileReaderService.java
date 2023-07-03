package service;

import java.util.List;
import model.FruitTransaction;

public interface CsvFileReaderService {
    List<FruitTransaction> readFromFile(String filePath);
}
