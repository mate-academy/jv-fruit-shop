package core.basesyntax.service;

import core.basesyntax.model.FruitNegotiation;
import java.util.List;

public interface FruitEvaluator {
    public void evaluate(List<FruitNegotiation> parsedData);
}
