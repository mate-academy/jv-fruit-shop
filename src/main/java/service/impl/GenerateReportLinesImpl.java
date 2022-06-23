package service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.GenerateReportLines;

public class GenerateReportLinesImpl implements GenerateReportLines {
    private static final int INDEX_OF_DESCRIPTION_FIELDS = 0;

    @Override
    public List<String> createReport(Map<String, Integer> fruitReport) {

        List<String> report = fruitReport.entrySet().stream()
                .map(m -> String.format("%s, %d", m.getKey(), m.getValue()))
                .collect(Collectors.toList());
        report.add(INDEX_OF_DESCRIPTION_FIELDS,"fruit,quantity");
        return report;
    }
}
