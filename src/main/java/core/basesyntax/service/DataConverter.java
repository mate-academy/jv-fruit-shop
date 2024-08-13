package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> converteData(List<String> dataFromFile);
}
