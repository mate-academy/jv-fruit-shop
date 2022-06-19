package core.basesyntax.daonew;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface BalanceDao {
    List<Transaction> getBalanceFromFile(String fileName);
}
