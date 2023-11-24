package service;

import java.util.List;
import model.FruitTransaction;

public interface FileReader {
    List<FruitTransaction> read(String inputFileName);
}
