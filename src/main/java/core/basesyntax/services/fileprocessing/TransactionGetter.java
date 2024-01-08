package core.basesyntax.services.fileprocessing;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface TransactionGetter {
    List<FruitTransaction> getTransactionsData(List<String[]> dividedData);
}
