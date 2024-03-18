package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessor {
    List<FruitTransaction> processAll(List<String> data);
}
