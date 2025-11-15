package core.basesyntax.service.impl;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private final ShopStorage storage;

    public ReportGeneratorImpl(ShopStorage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        String data = storage.getStorage().entrySet().stream()
                .map(entry -> entry.getKey() + ',' + entry.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
        builder.append(REPORT_HEADER)
                .append(System.lineSeparator())
                .append(data);
        return builder.toString();
    }
}
