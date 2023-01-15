package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FileReaderService {
    List<FruitTransaction> readDataFile(String path);
}
