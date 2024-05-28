package core.basesyntax.service;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final ShopService shopService;

    public ReportGeneratorImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public String getReport() {
        Map<String, Integer> storage = shopService.getStorage();
        return "fruit,quantity\n"
                + storage.entrySet().stream()
                        .map(entry -> entry.getKey() + "," + entry.getValue())
                        .collect(Collectors.joining("\n"));
    }
}
