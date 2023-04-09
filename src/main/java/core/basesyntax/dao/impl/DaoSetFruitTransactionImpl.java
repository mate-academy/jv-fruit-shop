package core.basesyntax.dao.impl;

import core.basesyntax.dao.DaoSetFruitTransaction;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DaoSetFruitTransactionImpl implements DaoSetFruitTransaction {
    @Override
    public void apply(List<FruitTransaction> fruitTransactionList) {
        Storage.records.clear();
        Storage.records.addAll(fruitTransactionList);
    }
}
