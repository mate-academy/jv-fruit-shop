package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String WORD_SEPARATOR = ",";

    @Override
    public String getReport() {
        if (Storage.getFruits().isEmpty()) {
            return HEADER;
        }
        return HEADER + System.lineSeparator()
                + Storage.getFruits().entrySet().stream()
                        .map(fruit
                                -> fruit.getKey() + WORD_SEPARATOR + fruit.getValue())
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
