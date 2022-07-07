package core.service;

import core.db.FruitTransaction;
import java.util.List;

public interface TransactionService {
    List<FruitTransaction> createFromList(List<String> transactions);
}
