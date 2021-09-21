package core.basesyntax.service.report;

import core.basesyntax.model.FruitType;
import java.util.Map;

public interface FruitAmountCounter {
    Map<FruitType, Integer> countFruitByOperation();
}
