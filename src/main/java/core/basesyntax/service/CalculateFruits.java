package core.basesyntax.service;

import core.basesyntax.database.FruitActivity;
import java.util.List;
import java.util.Map;

public interface CalculateFruits {
    Map<String, Integer> calculate(List<FruitActivity> activities);
}
