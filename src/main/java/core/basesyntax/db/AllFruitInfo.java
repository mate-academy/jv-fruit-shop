package core.basesyntax.db;

import core.basesyntax.model.FruitInfo;
import java.util.ArrayList;
import java.util.List;

public class AllFruitInfo {
    private List<FruitInfo> fruitInfoList = new ArrayList<>();

    public List<FruitInfo> getFruitInfoList() {
        return fruitInfoList;
    }

    public void setFruitInfoList(List<FruitInfo> fruitInfoList) {
        this.fruitInfoList = fruitInfoList;
    }
}
