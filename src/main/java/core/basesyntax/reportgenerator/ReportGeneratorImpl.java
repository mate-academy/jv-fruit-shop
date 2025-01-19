package core.basesyntax.reportgenerator;

import core.basesyntax.shopservice.ShopService;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit, quantity";
    private static final String FORMAT = "%s,%d";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final ShopService shopService;

    public ReportGeneratorImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(LINE_SEPARATOR);

        Map<String, Integer> storage = shopService.getStorage();

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            String fruit = entry.getKey();
            Integer quantity = entry.getValue();
            report.append(String.format(FORMAT, fruit, quantity))
                    .append(LINE_SEPARATOR);
        }

        return report.toString();
    }
}
