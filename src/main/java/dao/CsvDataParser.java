package dao;

import java.util.List;
import model.FruitTransaction;

public interface CsvDataParser {
    List<FruitTransaction> parseData(String filePath);
}
