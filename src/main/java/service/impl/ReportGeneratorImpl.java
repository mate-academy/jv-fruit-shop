package service.impl;

import static service.impl.StorageDao.storage;

import interfaces.ReportGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = storage;
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        sb.append(HEADER).append(System.lineSeparator());

        for (String key : keys) {
            sb.append(key)
                    .append(SEPARATOR)
                    .append(map.get(key))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
