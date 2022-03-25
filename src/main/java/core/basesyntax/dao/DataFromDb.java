package core.basesyntax.dao;

import java.util.List;
import java.util.Map;

public interface DataFromDb {
    int OPERATION = 0;
    int FRUIT_NAME = 1;
    int QUANTITY = 2;
    Map<String, List<String[]>> readFileToMap();
}
