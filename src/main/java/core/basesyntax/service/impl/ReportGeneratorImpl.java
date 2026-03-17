package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final ShopServiceImpl shopService;

    public ReportGeneratorImpl(ShopServiceImpl shopService) {
        this.shopService = Objects.requireNonNull(shopService);
    }

    @Override
    public String getReport() {
        Map<String, Integer> storage = shopService.getStorage();
        // Build CSV: header + lines.
        // Keep iteration order by fruit name (sorted) for deterministic output.
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
