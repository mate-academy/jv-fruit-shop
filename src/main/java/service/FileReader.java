package service;

import java.io.FileNotFoundException;
import java.util.List;
import model.FruitTransaction;

public interface FileReader {
    List<String> read(String fileName) throws FileNotFoundException;

    FruitTransaction getFromCsvRow(String fileName);
}
