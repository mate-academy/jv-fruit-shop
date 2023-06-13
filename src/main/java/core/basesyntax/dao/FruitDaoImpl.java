package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String name, int quantity) {
        Storage.storage.put(name, quantity);
    }

    @Override
    public int get(String name) {
        return Storage.storage.get(name);
    }

    @Override
    public boolean containsFruit(String name) {
        return Storage.storage.containsKey(name);
    }

    @Override
    public String getDataForReportFile() {
        StringBuilder reportStringBuilder = new StringBuilder();
        reportStringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            reportStringBuilder.append(entry.getKey())
                    .append(',')
                    .append(entry.getValue().toString())
                    .append(System.lineSeparator());
        }
        return reportStringBuilder.toString();
    }
}
