package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionService {
    List<FruitTransaction> parseTransactions(List<String> sourceContent);

    void processTransactions(List<FruitTransaction> fruitTransactionList);
}
