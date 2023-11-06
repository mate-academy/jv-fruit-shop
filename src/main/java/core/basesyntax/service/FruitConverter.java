package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitConverter {
    List<FruitTransaction> convertData(List<String> dataFromFile);
}
