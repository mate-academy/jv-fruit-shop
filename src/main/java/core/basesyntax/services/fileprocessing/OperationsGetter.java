package core.basesyntax.services.fileprocessing;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface OperationsGetter {
    List<FruitTransaction> getOperationsData(List<String> rawData);
}
