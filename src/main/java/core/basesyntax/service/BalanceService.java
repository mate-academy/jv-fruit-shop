package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.List;

public interface BalanceService {
    List<Fruit> calculateBalance(List<Transaction> transactionsFromFile);
}
