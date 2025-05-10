package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private final ShopService shopService;

    public ReportGeneratorImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    public String getReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : shopService.getStorage().entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
