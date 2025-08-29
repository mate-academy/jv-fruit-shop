package basesyntax.service;

import basesyntax.common.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> rawData);
}
