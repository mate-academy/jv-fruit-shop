package core.basesyntax.model;

import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionReport {
    private static final String REPORT_START_LINE = "fruit,quantity";

    private final List<Entry> entries;

    public FruitTransactionReport(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        String fruitsInfo = entries.stream()
                .map(entry -> String.format("%s,%d", entry.fruit, entry.quantity))
                .collect(Collectors.joining(System.lineSeparator()));
        return String.format("%s%n%s", REPORT_START_LINE, fruitsInfo);
    }

    public static class Entry {
        private final String fruit;
        private final int quantity;

        public Entry(String fruit, int quantity) {
            this.fruit = fruit;
            this.quantity = quantity;
        }
    }
}
