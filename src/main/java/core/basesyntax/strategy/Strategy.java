package core.basesyntax.strategy;

import java.util.Map;

public interface Strategy {
    int countBalance(String fruit, String quantity, Map<String, String> map);
}
