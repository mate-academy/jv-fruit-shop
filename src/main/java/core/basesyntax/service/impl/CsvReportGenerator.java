package core.basesyntax.service.impl;

import core.basesyntax.db.Dao;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class CsvReportGenerator implements ReportGenerator<Dao<String, Integer>> {
    private final String header;
    private final String csvSeparator;

    public CsvReportGenerator(String header, String csvSeparator) {
        this.header = header;
        this.csvSeparator = csvSeparator;
    }

    @Override
    public Collection<String> generateReport(Dao<String, Integer> source) {
        final Collection<String> report = new ArrayList<>();
        report.add(header);
        report.addAll(source.getAll().stream()
                .map(e -> e.getKey() + csvSeparator + e.getValue())
                .collect(Collectors.toList()));
        return report;
    }
}
