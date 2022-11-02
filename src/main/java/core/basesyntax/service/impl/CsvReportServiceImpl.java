package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportingService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReportServiceImpl implements ReportingService {
    public static final String CSV_SEPARATOR = ",";
    private String header;

    public CsvReportServiceImpl(String header) {
        this.header = header;
    }

    @Override
    public List<String> generateReport() {
        List<String> report = new ArrayList<>(Storage.storage.size() + 1);
        report.add(header);
        report.addAll(getDataFromStorageInKeyValueView());
        return report;
    }

    private List<String> getDataFromStorageInKeyValueView() {
        return Storage.storage.entrySet().stream()
                .map(e -> e.getKey() + CSV_SEPARATOR + e.getValue())
                .collect(Collectors.toList());
    }
}
