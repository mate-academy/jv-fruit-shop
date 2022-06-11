package service;

import java.io.File;
import java.util.List;
import model.FruitTransaction;

public interface FileService {

    List<FruitTransaction> read(File file);

    void writeFile(File file, List<String[]> message);
}
