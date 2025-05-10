package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessorService {
    List<FruitTransaction> processInputData(List<String> dataFromFile);
}
