package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Processing {
    List<FruitTransaction> getProcessedData(List<String> textReport);
}
