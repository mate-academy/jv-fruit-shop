package core.basesyntax.service.impl;

import core.basesyntax.service.db.Storage;
import core.basesyntax.service.service.ResultService;
import java.util.Map;

public class ResultServiceImpl implements ResultService {
    @Override
    public String createResult() {
        StringBuilder result = new StringBuilder();
        result.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry: Storage.storage.entrySet()) {
            result.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return result.toString();
    }
}
