package core.basesyntax.report;

import core.basesyntax.service.ShopService;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private ShopService shopService;

    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder("Fruit, Quantity\n");
        for (Map.Entry<String, Integer> entry: shopService.getFruits().entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return builder.toString();
    }
}
