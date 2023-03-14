package core.basesyntax.servicesimpl;

import core.basesyntax.services.ShopReportService;
import java.util.Map;

public class ShopReportServiceImpl implements ShopReportService {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String VALUE_SEPARATOR = ",";
    public static final String TITLE_ROW = "fruit,quantity";

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
