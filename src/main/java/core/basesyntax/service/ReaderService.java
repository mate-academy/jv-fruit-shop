package core.basesyntax.service;

import java.util.List;

public interface ReaderService {
    List<FruitTransaction> readFromFile(String fromFile);
}
