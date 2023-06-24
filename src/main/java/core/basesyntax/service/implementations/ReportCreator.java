package core.basesyntax.service.implementations;

import core.basesyntax.dao.StorageDao;
import java.util.Map;
import java.util.Set;

public class ReportCreator {
    private static final String REPORT_TEMPLATE = "fruit,quantity";
    private StorageDao storageDao;

    public ReportCreator(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public String provideReport(Set<Map.Entry<String, Integer>> storageData) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : storageData) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return REPORT_TEMPLATE + stringBuilder;
    }
}
