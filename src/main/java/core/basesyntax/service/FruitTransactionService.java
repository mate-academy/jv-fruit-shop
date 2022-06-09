package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionService {
    boolean addTransaction(List<String> dataFromCsv);

    List<FruitTransaction> getTransactionList();
}
