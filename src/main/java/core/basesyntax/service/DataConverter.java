package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> inputReport);
}
