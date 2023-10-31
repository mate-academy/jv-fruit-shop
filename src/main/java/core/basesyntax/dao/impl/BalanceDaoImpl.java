package core.basesyntax.dao.impl;

import core.basesyntax.dao.BalanceDao;
import core.basesyntax.db.BalanceProductValues;
import java.util.Map;

public class BalanceDaoImpl implements BalanceDao {
    private static final int GET_FAILURE_INDEX = -1;

    @Override
    public void add(String fruitName, int amount) {
        BalanceProductValues.productValuesOfBalance.put(fruitName, amount);
    }

    @Override
    public Integer get(String fruitName) {
        for (Map.Entry<String, Integer> good
                : BalanceProductValues.productValuesOfBalance.entrySet()) {
            if (fruitName.equals(good.getKey())) {
                return good.getValue();
            }
        }
        return GET_FAILURE_INDEX;
    }
}
