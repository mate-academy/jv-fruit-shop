package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DELIMITER = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> dataList = new ArrayList<>(Storage.fruitStorage.size());
        dataList.add(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            dataList.add(entry.getKey() + DELIMITER + entry.getValue());
        }
        return dataList;
    }
}
