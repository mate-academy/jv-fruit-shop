package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessingService {
    void processingDate(List<FruitTransaction> data);
}
