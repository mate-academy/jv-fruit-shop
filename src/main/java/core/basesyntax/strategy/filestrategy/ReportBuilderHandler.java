package core.basesyntax.strategy.filestrategy;

import core.basesyntax.strategy.filestrategy.impl.CsvReportBuilderImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ReportBuilderHandler {
    private final Map<String, ReportBuilder> reportBuilders = new HashMap<>();

    {
        reportBuilders.put(FileType.CSV.getName(), new CsvReportBuilderImpl());
    }

    public ReportBuilder getReportBuilder(String type) {
        Optional<ReportBuilder> reportBuilderOptional = Optional.of(reportBuilders.get(type));
        return reportBuilderOptional.orElseThrow(
                () -> new RuntimeException("Invalid file type " + type));
    }
}
