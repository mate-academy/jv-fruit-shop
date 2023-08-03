package core.basesyntax.interfaces;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionsFormer {
    List<FruitTransaction> formTransactionList(List<String> data);
}
