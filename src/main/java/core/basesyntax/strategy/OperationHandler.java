package core.basesyntax.strategy;

import java.util.Map;

public interface OperationHandler {
    Map<String, Integer> apply(
            Map<String, Integer> current,
            String fruit,
            int quantity
    );
}
