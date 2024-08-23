package service.report;

import data.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADLINE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateStorageReport() {
        StringBuilder stringStorage = new StringBuilder();
        stringStorage.append(HEADLINE);

        for (Map.Entry<String, Integer> storageMap : Storage.getFruitsStorage().entrySet()) {
            stringStorage.append(System.lineSeparator()).append(storageMap.getKey())
                    .append(SEPARATOR).append(storageMap.getValue());
        }

        return stringStorage.toString();
    }
}
