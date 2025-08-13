package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private final ShopService shopService;

    public ReportGeneratorImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("fruit").append(COMMA).append("quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : shopService.getStorage().entrySet()) {
            sb.append(entry.getKey()).append(COMMA).append(entry.getValue()).append(System
                    .lineSeparator());
        }
        return sb.toString();
    }
}
