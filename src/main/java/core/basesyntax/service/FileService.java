package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface FileService {

    List<FruitTransaction> readFile(String filePath);

    void writeFile(String filePath, List<String> output);
}
