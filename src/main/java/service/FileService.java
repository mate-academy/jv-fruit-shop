package service;

import java.io.File;
import java.util.List;
import model.FruitTransaction;

public interface FileService {
    List<FruitTransaction> readFile(File file);

    void writeFile(File file, List<String[]> message);
}
