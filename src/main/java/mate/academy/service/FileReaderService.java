package mate.academy.service;

import java.util.List;
import mate.academy.model.FruitTransaction;

public interface FileReaderService {
    List<FruitTransaction> readFromFile(String filePath);
}
