package core.basesyntax.db;

import java.util.List;
import java.util.Map;

public interface DataBase {
    void addFruitToStorage(String[] arr);

    void addBalanceOfFruit(String key, String val);

    List<String[]> getListOfFruitStorage();

    Map<String, String> getMapOfBalanceStorage();
}
