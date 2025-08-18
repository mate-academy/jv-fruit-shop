package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {

    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        List<String> result = new ArrayList<>();
        result.add(HEADER);
        result.addAll(Storage.getShopStorage().entrySet().stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue())
                .toList());
        return String.join(System.lineSeparator(), result);
    }
}
