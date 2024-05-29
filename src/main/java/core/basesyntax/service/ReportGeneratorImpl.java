package core.basesyntax.service;

import core.basesyntax.model.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final ShopService shopService;

    public ReportGeneratorImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public String getReport() {
        return "fruit,quantity" + System.lineSeparator()
                + Storage.FRUIT_STORAGE.entrySet().stream()
                        .map(entry -> entry.getKey() + "," + entry.getValue())
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
