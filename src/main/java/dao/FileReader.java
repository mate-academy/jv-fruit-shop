package dao;

import java.util.List;
import model.FruitTransaction;

public interface FileReader {
    List<FruitTransaction> readFile(String fileName);
}
