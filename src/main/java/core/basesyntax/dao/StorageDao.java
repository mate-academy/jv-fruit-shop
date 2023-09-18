package core.basesyntax.dao;

import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public interface StorageDao {
    boolean addValueToStorage(Map<Operation, Map<String, List<Integer>>> fruitMap,
                              Operation operation, String fruitName, int value);

    List<String> getListOfFruits(Map<Operation, Map<String, List<Integer>>> storage);

    String getFruits(String string);

    int getQuantity(String string);
}
