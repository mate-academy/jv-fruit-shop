package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportMaker;
import java.util.HashMap;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    private static final String REPORT_TABLE_COLUMNS = "fruit,quantity";

    @Override
    public String collectStorageStateToString() {
        StringBuilder result = new StringBuilder(REPORT_TABLE_COLUMNS);
        Map<String, Integer> groupedMap = groupQuantityByFruit();
        for (Map.Entry<String, Integer> entry : groupedMap.entrySet()) {
            result.append(System.lineSeparator()).append(entry.getKey())
                    .append(',').append(entry.getValue());
        }
        return result.toString();
    }
    
    private Map<String, Integer> groupQuantityByFruit() {
        Map<String, Integer> resultMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            Integer oldQuantity = resultMap.getOrDefault(entry.getKey(), 0);
            resultMap.put(entry.getKey(), oldQuantity + entry.getValue());
        }
        return resultMap; 
    }
}
