package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DaoSetFruitTransaction {
    void apply(List<FruitTransaction> fruitTransactionList);
}
