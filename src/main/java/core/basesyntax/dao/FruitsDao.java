package core.basesyntax;

import java.util.List;

public interface FruitsDao {
    List<FruitTransaction> getFruitsData(String fromFile);
}
