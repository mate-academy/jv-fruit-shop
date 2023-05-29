package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface AnalysisFileService {
    void process(List<FruitTransaction> data);
}
