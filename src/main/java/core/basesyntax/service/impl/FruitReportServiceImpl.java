package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    private static final String SERVICE_INFO = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public List<String> createReport() {
        if (Storage.storage.isEmpty()) {
            throw new RuntimeException("Can`t create report. Storage is empty");
        }
        List<String> result = new ArrayList<>();
        result.add(SERVICE_INFO);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            result.add(entry.getKey() + COMMA + entry.getValue());
        }
        return result;
    }
}
