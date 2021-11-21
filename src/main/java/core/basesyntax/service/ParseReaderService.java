package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseReaderService {
    List<FruitTransaction> getFruitList(List<String> dataFromFile);
}
