package core.basesyntax.dataservice;

import core.basesyntax.transactions.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> data);
}
