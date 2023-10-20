package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileService {
    List<FruitTransaction> readFile(String fileName);

    void writeToFile(String fileName, String data);
}
