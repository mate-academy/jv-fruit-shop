package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionService {

    List<FruitTransaction> getFruitTransactionsFromData(List<String> activities);
}
