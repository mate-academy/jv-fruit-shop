package core.basesyntax.dao;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorageDaoImpl implements StorageDao {
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public boolean addValueToStorage(Map<Operation, Map<String, List<Integer>>> fruitMap,
                                            Operation operation, String fruitName, int value) {
        Map<String, List<Integer>> fruitsAndQuantityMap = fruitMap.get(operation);
        if (fruitsAndQuantityMap == null) {
            fruitsAndQuantityMap = new HashMap<>();
            fruitMap.put(operation, fruitsAndQuantityMap);
        }
        List<Integer> values = fruitsAndQuantityMap.get(fruitName);
        if (values == null) {
            values = new ArrayList<>();
            fruitsAndQuantityMap.put(fruitName, values);
        }
        return values.add(value);
    }

    @Override
    public List<String> getListOfFruits(Map<Operation, Map<String, List<Integer>>> storage) {
        return storage.values()
                .stream()
                .flatMap(innerMap -> innerMap.keySet().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public String getFruits(String rowFromOperationList) {
        String[] split = rowFromOperationList.split(SEPARATOR);
        return split[FRUIT_INDEX];
    }

    @Override
    public int getQuantity(String rowFromOperationList) {
        String[] split = rowFromOperationList.split(SEPARATOR);
        return Integer.parseInt(split[QUANTITY_INDEX]);
    }
}
