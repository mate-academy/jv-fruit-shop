package core.basesyntax.report;

import core.basesyntax.db.Storage;
import java.util.stream.StreamSupport;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder(HEADER).append(System.lineSeparator());
        StreamSupport.stream(storage.getAllKeys().spliterator(), false)
                .sorted()
                .forEach(k -> sb.append(k).append(",")
                        .append(storage.read(k)).append(System.lineSeparator()));
        return sb.toString();
    }
}
