package core.basesyntax.strategy;

import java.util.Map;

public interface AddToBalanceStrategy extends ExistFruit {
    void action(Map<String, Integer> dataForReport, String fruit, Integer quantity);
}
