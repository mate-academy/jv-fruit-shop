package core.basesyntax.service;

import core.basesyntax.strategy.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> rawData);
}
