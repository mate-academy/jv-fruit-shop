package core.basesyntax.model;

import java.util.Map;

public record Fruit(
        String name,
        Map<Operation, Integer> operation
) {
}
