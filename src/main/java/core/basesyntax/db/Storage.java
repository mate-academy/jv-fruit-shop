package core.basesyntax.db;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface Storage {
    List<Transaction> getTransactions();
}
