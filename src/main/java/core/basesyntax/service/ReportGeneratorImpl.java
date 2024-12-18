package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String HEAD_LINE = "fruit,quantity";
    public static final String COMMA = ",";

    @Override
    public String getReport() {
        return HEAD_LINE
                + System.lineSeparator()
                + FruitStorage.fruits.entrySet().stream()
                .map(e -> e.getKey() + COMMA + e.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
