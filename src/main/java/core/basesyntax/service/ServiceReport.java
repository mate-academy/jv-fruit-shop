package core.basesyntax.service;

import java.util.Map;


import static core.basesyntax.db.Storage.storage;

public class ServiceReport implements IServiceReport {
    private static final String HEADER = "fruit,quantity\n";
    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry: storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
