package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitDaoService;
import java.util.List;

public class FruitDaoServiceImpl implements FruitDaoService {
    @Override
    public void add(List<FruitTransaction> transaction) {

        Storage.transaction.addAll(transaction);
    }

    @Override
    public List<FruitTransaction> get() {
        return Storage.transaction;
    }
}
