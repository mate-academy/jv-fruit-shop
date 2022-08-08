package core.basesyntax.separator;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface CreateTransactions {
    List<Transaction> getAllTransactions(List<String> readLine);
}
