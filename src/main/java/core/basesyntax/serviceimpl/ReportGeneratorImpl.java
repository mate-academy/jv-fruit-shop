package core.basesyntax.serviceimpl;

import core.basesyntax.ReportGenerator;
import core.basesyntax.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity\n";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : storage.getAll().entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return report.toString();
    }
}
