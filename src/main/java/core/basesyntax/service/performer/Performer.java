package core.basesyntax.service.performer;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Performer {
    void performTransaction(List<FruitTransaction> fruitTransactionList);
}
