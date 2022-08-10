package core.basesyntax.separator;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FruitTransactionsParcer {
    List<Transaction> transactionsParcer(List<String> readLine);
}
