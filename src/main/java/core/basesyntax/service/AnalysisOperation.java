package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface AnalysisOperation {
    void processing(List<FruitTransaction> data);
}
