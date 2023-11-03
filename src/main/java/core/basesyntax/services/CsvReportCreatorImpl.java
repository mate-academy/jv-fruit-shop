package core.basesyntax.services;

import core.basesyntax.db.Storage;
import core.basesyntax.serviceinterfaces.ReportCreator;
import java.util.stream.Collectors;

public class CsvReportCreatorImpl implements ReportCreator {
    private static final String CSV_SEPARATOR = ",";
    private static final String REPORT_FORMAT = "%s%s%d";
    private static final String REPORT_WITH_HEADER_FORMAT = "%s%n%s";
    private static final String HEADER = "fruit" + CSV_SEPARATOR + "quantity";

    @Override
    public String createReport() {
        String report = Storage.fruits.entrySet().stream()
                .map(e -> String.format(REPORT_FORMAT, e.getKey(), CSV_SEPARATOR, e.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format(REPORT_WITH_HEADER_FORMAT, HEADER, report);
    }
}
