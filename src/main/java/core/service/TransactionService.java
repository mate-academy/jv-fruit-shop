package core.service;

import core.db.FruitTransaction;
import java.util.List;

public interface TransactionService {
    FruitTransaction createFromString(String stringTransaction);

    List<FruitTransaction> createFromList(List<String> transactions);
}
