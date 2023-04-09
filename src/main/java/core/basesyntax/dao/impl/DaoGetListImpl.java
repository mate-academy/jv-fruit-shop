package core.basesyntax.dao.impl;

import core.basesyntax.dao.DaoGetList;
import core.basesyntax.db.Storage;
import core.basesyntax.function.impl.FruitTransactionsToStrings;
import java.util.ArrayList;
import java.util.List;

public class DaoGetListImpl implements DaoGetList {
    @Override
    public List<String> apply() {
        FruitTransactionsToStrings fruitTransactionsToStrings = new FruitTransactionsToStrings();
        List<String> reportStringFruitsTransactions
                = fruitTransactionsToStrings.apply(new ArrayList<>(Storage.records));
        return reportStringFruitsTransactions;
    }
}
