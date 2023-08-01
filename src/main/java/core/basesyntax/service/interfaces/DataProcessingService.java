package core.basesyntax.service.interfaces;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessingService {
    void processData(List<FruitTransaction> transactions);
}
