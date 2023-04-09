package core.basesyntax.dao.impl;

import core.basesyntax.dao.DaoGetFruitTransaction;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DaoGetFruitTransactionImpl implements DaoGetFruitTransaction {
    @Override
    public List<FruitTransaction> apply() {
        return Storage.records.stream()
                .collect(Collectors.toList());
    }
}
