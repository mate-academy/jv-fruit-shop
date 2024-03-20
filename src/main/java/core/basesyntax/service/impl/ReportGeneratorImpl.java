package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DELIMITER = ",";

    @Override
    public List<String> createReport(Map<String, Integer> fruitTransactionDtoList) {
        List<String> dataList = new ArrayList<>(fruitTransactionDtoList.size());
        for (Map.Entry<String, Integer> entry : fruitTransactionDtoList.entrySet()) {
            dataList.add(entry.getKey() + DELIMITER + entry.getValue());
        }
        return dataList;
    }
}
