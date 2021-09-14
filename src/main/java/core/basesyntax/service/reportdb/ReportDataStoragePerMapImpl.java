package core.basesyntax.service.reportdb;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReportDataStoragePerMapImpl implements ReportDataStorage {
    private HashMap<String, Integer> dataStorageMap;

    public ReportDataStoragePerMapImpl(HashMap<String, Integer> dataStorageMap) {
        this.dataStorageMap = dataStorageMap;
    }

    @Override
    public boolean acceptData(String fruit, Integer amount) {
        dataStorageMap.put(fruit, amount);
        return dataStorageMap.get(fruit) != null;
    }

    @Override
    public Integer getDataPerFruit(String fruit) {
        return dataStorageMap.get(fruit);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAllData() {
        return dataStorageMap.entrySet();
    }
}
