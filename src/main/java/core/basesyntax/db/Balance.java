package core.basesyntax.db;

import core.basesyntax.model.FruitType;

import java.util.HashMap;
import java.util.Map;

public class Balance {

    private Map<FruitType, Integer> balanceMap;

    public Map<FruitType, Integer> getBalanceMap() {
        return balanceMap;
    }

    public void setBalanceMap(Map<FruitType, Integer> balanceMap) {
        this.balanceMap = balanceMap;
    }
}

