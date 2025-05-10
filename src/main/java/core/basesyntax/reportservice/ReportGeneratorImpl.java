package core.basesyntax.reportservice;

import core.basesyntax.storage.DateFruits;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADERS = "fruit, amount" + System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADERS);
        stringBuilder.append(DateFruits.getAll().entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator())));
        return stringBuilder.toString();
    }
}
