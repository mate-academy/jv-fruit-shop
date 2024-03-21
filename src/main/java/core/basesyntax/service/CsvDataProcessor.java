package core.basesyntax.service;

import java.util.List;

public class CsvDataProcessor {
    public List<String> processCsvData(List<String> data) {
        if (!data.isEmpty()) {
            data.remove(0);
        }
        return data;
    }
}
