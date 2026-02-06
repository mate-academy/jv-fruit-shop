package basesyntax.service;

import basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> lines);
}
