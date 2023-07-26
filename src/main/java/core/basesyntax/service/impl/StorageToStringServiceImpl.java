package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageToStringService;
import java.util.Map;

public class StorageToStringServiceImpl implements StorageToStringService {
    @Override
    public String convert() {
        StringBuilder stringBuilder = new StringBuilder("fruits,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
