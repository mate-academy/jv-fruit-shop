package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;
import java.util.List;

public interface OperationManager {
    void addInfoToDB(List<String> stringList, FruitDB fruitDB);
}
