package core.basesyntax.impl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(ShopService shopService) {
        ShopServiceImpl shopServiceImpl = (ShopServiceImpl) shopService;
        Map<String, Integer> storage = shopServiceImpl.getStorage();

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity").append(System.lineSeparator());

        // Iterate over the storage and build the report
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return reportBuilder.toString().trim();
    }
}
