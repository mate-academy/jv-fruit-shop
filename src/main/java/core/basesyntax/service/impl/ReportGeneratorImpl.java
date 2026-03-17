package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Generates CSV report from storage. Depends on ShopService (interface).
 */
public class ReportGeneratorImpl implements ReportGenerator {
    private final ShopService shopService;

    public ReportGeneratorImpl(ShopService shopService) {
        this.shopService = Objects.requireNonNull(shopService);
    }

    @Override
    public String getReport() {
        Map<String, Integer> storage = shopService.getStorage();
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity").append(System.lineSeparator());
        String body = storage.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + "," + e.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        if (!body.isEmpty()) {
            sb.append(body).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
