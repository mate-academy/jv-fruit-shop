package core.basesyntax.strategy.dataprocessor;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessor {
    List<FruitTransaction> parseTransactions(String data);
}
