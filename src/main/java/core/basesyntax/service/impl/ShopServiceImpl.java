package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopService;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private static final String SEPARATOR = ",";
    private static final String REPORT_TITLE = "fruit,quantity";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_TITLE)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry: Storage.STORAGE.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
