package core.basesyntax.service.reportdb;

import java.util.Map;
import java.util.Set;

public interface ReportDataStorage {
    boolean acceptData(String fruit, Integer amount);

    Integer getDataPerFruit(String fruit);

    Set<Map.Entry<String, Integer>> getAllData();
}



