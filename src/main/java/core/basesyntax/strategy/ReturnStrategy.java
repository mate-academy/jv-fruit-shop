package core.basesyntax.strategy;

import java.util.Map;

public interface ReturnStrategy extends ExistFruit {
    void action(Map<String, Integer> dataForReport, String fruit, Integer quantity);
}
