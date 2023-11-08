package core.basesyntax.dao.transaction;

import java.util.List;

public interface Transaction {
    List<FruitTransaction> getTransactionList(List<String> stringList);
}
