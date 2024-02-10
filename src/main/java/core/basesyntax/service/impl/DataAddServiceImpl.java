package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataAddService;
import java.util.List;

public class DataAddServiceImpl implements DataAddService {
    @Override
    public void addData(List<FruitTransaction> data) {
        Storage.fruitTransactions.addAll(data);
    }
}
