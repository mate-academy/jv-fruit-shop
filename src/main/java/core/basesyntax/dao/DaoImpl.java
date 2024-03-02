package core.basesyntax.dao;

import core.basesyntax.db.AllFruitInfo;
import core.basesyntax.db.Balance;
import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;

import java.util.List;
import java.util.Map;

public class DaoImpl implements Dao {

    private Balance balance = new Balance();
    private AllFruitInfo allFruitInfo = new AllFruitInfo();

    @Override
    public void transferToBalance(Map<FruitType, Integer> map) {
        balance.setBalanceMap(map);
    }

    @Override
    public Map<FruitType, Integer> getInfoFromBalance() {
        return balance.getBalanceMap();
    }

    @Override
    public void transferToAllFruit(List<FruitInfo> fruitList) {
        allFruitInfo.setFruitInfoList(fruitList);
    }

    @Override
    public List<FruitInfo> getInfoFromAllFruit() {
        return allFruitInfo.getFruitInfoList();
    }


}
