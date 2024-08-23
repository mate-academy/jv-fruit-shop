package core.basesyntax.utils.generate.impl.csv;

import core.basesyntax.storage.impl.StorageImpl;
import core.basesyntax.utils.generate.ReportGenerator;

public class CsvGeneratorImpl implements ReportGenerator {
    private static final String LINE_SEPARATOR = ",";
    private static final String REPORT_INIT = "fruit,quantity";

    @Override
    public String getReport(StorageImpl storage) {
        StringBuilder sb = new StringBuilder();
        sb.append(REPORT_INIT);
        storage.getAllEntries().forEach(entry -> sb.append(System.lineSeparator())
                .append(entry.getProduct())
                .append(LINE_SEPARATOR)
                .append(entry.getQuantity()));
        return sb.toString();
    }
}
