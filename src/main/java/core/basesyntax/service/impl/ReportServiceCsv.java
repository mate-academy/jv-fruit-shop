package core.basesyntax.service.impl;

import core.basesyntax.db.DaoService;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ReportServiceCsv
        implements ReportService<DaoService<String, Integer>> {
    private final String header;
    private final String csvSeparator;

    public ReportServiceCsv(String header, String csvSeparator) {
        this.header = header;
        this.csvSeparator = csvSeparator;
    }

    @Override
    public Collection<String> generateReport(DaoService<String, Integer> source) {
        final Collection<String> report = new ArrayList<>();
        report.add(header);
        report.addAll(source.getAll().stream()
                .map(e -> e.getKey() + csvSeparator + e.getValue())
                .collect(Collectors.toList()));
        return report;
    }
}
