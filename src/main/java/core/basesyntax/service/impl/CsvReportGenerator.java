package core.basesyntax.service.impl;

import core.basesyntax.db.Dao;
import core.basesyntax.service.ReportGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvReportGenerator implements ReportGenerator<Dao<String, Integer>> {
    private final String HEADER;
    private final String CSV_SEPARATOR;

    public CsvReportGenerator(String header, String csvSeparator) {
        this.HEADER = header;
        CSV_SEPARATOR = csvSeparator;
    }

    @Override
    public Collection<String> generateReport(Dao<String, Integer> source) {
        final Collection<String> report = new ArrayList<>();
        report.add(HEADER);
        report.addAll(source.getAll().stream()
                .map(e -> e.getKey() + CSV_SEPARATOR + e.getValue())
                .collect(Collectors.toList()));
        return report;
    }
}
