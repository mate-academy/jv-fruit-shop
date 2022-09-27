package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.nio.file.Path;
import java.util.List;

public interface FileReaderService {
    List<FruitTransaction> read(String filePath);
}
