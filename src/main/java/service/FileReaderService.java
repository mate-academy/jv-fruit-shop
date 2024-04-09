package service;

import java.io.File;
import java.util.List;
import model.FruitTransaction;

public interface FileReaderService {
    List<FruitTransaction> readFromFile(File file);
}
