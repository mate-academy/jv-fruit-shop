package servise.calculate;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface CalculateFruits {
    Map<String, List<FruitTransaction>> calculateFruits(List<String> list);
}
