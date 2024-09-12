package service;

import java.util.List;
import model.FruitTransaction;

public interface DataReaderService {
    List<FruitTransaction> readDataInFile(String filePath);
}
