package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.Map;

public interface TransactionMapper {
    List<Transaction> stringsToTransactions(List<String> transStrings);

    List<String> storageToStrings(Map<Fruit, Integer> storage);
}
