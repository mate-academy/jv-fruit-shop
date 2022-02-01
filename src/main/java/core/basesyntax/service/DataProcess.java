package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcess {
    void processingData(List<FruitTransaction> fileData);
}
