package core.basesyntax.services.impl;

import core.basesyntax.services.ShopReportService;
import java.util.Map;

public class ShopReportServiceImpl implements ShopReportService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String VALUE_SEPARATOR = ",";
    private static final String TITLE_ROW = "fruit,quantity";

    @Override
    public byte[] generateReport(Map<String, Integer> processedData) {
        StringBuilder sb = new StringBuilder().append(TITLE_ROW).append(LINE_SEPARATOR);
        processedData.forEach((key, value) -> sb.append(key)
                .append(VALUE_SEPARATOR)
                .append(value)
                .append(LINE_SEPARATOR));
        return sb.toString().getBytes();
    }
}
