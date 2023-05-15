package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopService;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private static final String separator = ",";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry: Storage.STORAGE.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(separator)
                    .append(entry.getValue());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
