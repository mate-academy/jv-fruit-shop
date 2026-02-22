package core.basesyntax.service;

import core.basesyntax.model.transaction.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> inputReport);
}
