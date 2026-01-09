package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvProcessor {
    private final OperationStrategy strategy;

    public CsvProcessor(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public Map<String, Integer> process(List<String> lines) {
        Map<String, Integer> result = new HashMap<>();

        for (String line : lines) {
            if (line.startsWith("type")) {
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new RuntimeException("Invalid line: " + line);
            }

            Storage.Operation operation =
                    Storage.Operation.fromCode(parts[0]);

            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity: " + parts[2]);
            }

            result = strategy
                    .get(operation)
                    .apply(result, parts[1], quantity);
        }

        return result;
    }
}
