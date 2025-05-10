package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport(ShopService shopService) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity \n");
        for (Map.Entry<String, Integer> entry: shopService.getFruits().entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
