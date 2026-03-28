package core.basesyntax.service.impl;

import core.basesyntax.model.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.Set;

public class ReportGeneratorImpl implements ReportGenerator {

    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        Map<String, Integer> storageMap = storage.getStorage();
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity\n");
        Set<Map.Entry<String, Integer>> entries = storageMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey() + "," + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
