package core.basesyntax.reportgenerator;

import core.basesyntax.dao.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
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

    private void createReport(){

    }
}
