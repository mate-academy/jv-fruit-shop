package core.basesyntax.dao.impl;

import core.basesyntax.dao.DaoSetList;
import core.basesyntax.db.Storage;
import core.basesyntax.function.impl.StringToFruitTransaction;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DaoSetListImpl implements DaoSetList {
    public static final int INDEX_TITLE = 0;

    @Override
    public void apply(List<String> list) {
        Storage.records.clear();
        StringToFruitTransaction stringToFruitTransaction = new StringToFruitTransaction();
        list.remove(INDEX_TITLE);
        List<FruitTransaction> fruitTransactionList = list.stream()
                .map(stringToFruitTransaction)
                .collect(Collectors.toList());
        Storage.records.addAll(fruitTransactionList);
    }
}
