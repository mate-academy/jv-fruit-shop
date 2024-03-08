package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = System.lineSeparator();

    @Override
    public String createReport() {
        Map<String, Integer> products = Storage.getElements();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(SEPARATOR);
        for (Map.Entry<String, Integer> product : products.entrySet()) {
            stringBuilder.append(String.format("%s,%d", product.getKey(),
                    product.getValue())).append(SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
