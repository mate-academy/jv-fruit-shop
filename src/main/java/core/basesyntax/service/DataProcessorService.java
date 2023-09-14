package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessorService {
    void processData(List<FruitTransaction> data);
}
