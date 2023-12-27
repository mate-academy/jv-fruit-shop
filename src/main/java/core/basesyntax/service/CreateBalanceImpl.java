package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Iterator;
import java.util.Map;

public class CreateBalanceImpl implements CreateBalance {
    @Override
    public String createReport() {
        StringBuilder line = new StringBuilder();
        line.append("fruit,quantity" + "\n");
        Iterator<Map.Entry<String, Integer>> entryIterator = Storage.storage.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            line.append(entry.getKey() + "," + entry.getValue() + "\n");
        }
        return line.toString();
    }
}
