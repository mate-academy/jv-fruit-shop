package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitBalance;
import java.util.List;

public class FruitBalanceDaoImpl implements FruitBalanceDao {
    @Override
    public void add(FruitBalance fruitBalance) {
        Storage.fruitBalanceInfo.add(fruitBalance);
    }

    @Override
    public List<FruitBalance> get() {
        return Storage.fruitBalanceInfo;
    }
}
