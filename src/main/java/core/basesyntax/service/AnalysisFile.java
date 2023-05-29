package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface AnalysisFile {
    void process(List<FruitTransaction> data);
}
