package core.basesyntax.service;

import static core.basesyntax.db.Storage.storage;

import java.util.Map;

public class ServiceReportImpl implements ServiceReport {
    private static final String HEADER = "fruit,quantity\n";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry: storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
