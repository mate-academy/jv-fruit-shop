package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReaderService {
    List<FruitTransaction> read(String filePath);
}
