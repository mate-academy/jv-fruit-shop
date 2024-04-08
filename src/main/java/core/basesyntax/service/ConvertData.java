package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertData {
    List<FruitTransaction> convertToTransaction(List<String> transactionData);
}
