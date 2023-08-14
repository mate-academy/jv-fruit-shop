package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParseService {
    List<FruitTransaction> getTransactionData(List<String> data);
}
