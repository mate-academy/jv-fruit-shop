package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface DataProcessor {
    void process(List<FruitTransaction> transactions);
}
