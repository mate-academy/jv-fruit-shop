package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvFileReportServiceImpl implements CsvFileReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> products) {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            String line = entry.getKey() + SEPARATOR + entry.getValue();
            lines.add(line);
        }
        return String.join(System.lineSeparator(), lines);
    }
}
