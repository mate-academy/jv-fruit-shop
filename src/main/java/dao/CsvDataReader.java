package dao;

import java.util.List;
import model.FruitTransaction;

public interface CsvDataReader {
    List<FruitTransaction> readDataFromFile(String filePath);
}
