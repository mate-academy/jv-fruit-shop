package core.basesyntax.reportgenerator;

import core.basesyntax.dao.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private String report;
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        createReport();
        return report;
    }

    private void createReport() {
        StringBuilder sb = new StringBuilder(REPORT_FIRST_LINE);
        storage.getStorage()
                .forEach((key, value) ->
                        sb.append(System.lineSeparator()).append(key).append(",").append(value)
                );

        this.report = sb.toString();
    }
}
