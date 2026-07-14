package core.basesyntax.report;

import core.basesyntax.maps.StorageForFruitsAndQuantity;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    private final StorageForFruitsAndQuantity storage;

    public ReportImpl(StorageForFruitsAndQuantity storage) {
        this.storage = storage;
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder(HEADER);

        for (Map.Entry<String, Integer> entry
                : storage.getStorage().entrySet()) {

            StringBuilder append = report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }

        return report.toString();
    }
}
