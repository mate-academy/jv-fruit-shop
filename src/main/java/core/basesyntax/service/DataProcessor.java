package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessor {
    public List<FruitTransaction> process(List<String> transactions);
}
