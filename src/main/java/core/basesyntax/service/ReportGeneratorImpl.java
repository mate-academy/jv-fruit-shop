package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String HEAD_LINE = "fruit,quantity";
    public static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(HEAD_LINE);
        List<String> fruits = FruitStorage.fruits.entrySet().stream()
                .map(e -> e.getKey() + COMMA + e.getValue())
                .toList();
        for (String fruit : fruits) {
            builder.append(System.lineSeparator()).append(fruit);
        }
        return builder.toString();
    }
}
