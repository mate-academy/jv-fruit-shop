package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeOfFruit;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    private Map<TypeOfFruit, Integer> balanceMap;
    private List<FruitTransaction> fruitInfoList;

    public Map<TypeOfFruit, Integer> getBalanceMap() {
        return balanceMap;
    }

    public void setBalanceMap(Map<TypeOfFruit, Integer> balanceMap) {
        this.balanceMap = balanceMap;

    }

    public List<FruitTransaction> getFruitInfoList() {
        return fruitInfoList;
    }

    public void setFruitInfoList(List<FruitTransaction> fruitInfoList) {
        this.fruitInfoList = fruitInfoList;
    }
}

