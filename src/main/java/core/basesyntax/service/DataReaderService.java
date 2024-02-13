package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataReaderService {
    List<FruitTransaction> readDataFromFile(String fileName);
}
