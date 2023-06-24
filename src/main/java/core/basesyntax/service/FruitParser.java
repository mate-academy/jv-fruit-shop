package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitParser {
    List<FruitTransaction> parseData(String dataFromFile);
}
