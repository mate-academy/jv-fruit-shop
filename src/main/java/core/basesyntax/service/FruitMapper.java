package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitMapper {
    List<FruitTransaction> convertData(List<String> dataFromFile);
}
