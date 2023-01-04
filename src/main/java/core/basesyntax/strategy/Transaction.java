package core.basesyntax.strategy;

import core.basesyntax.model.FruitsTranslation;
import java.util.List;
import java.util.Map;

public interface Transaction {
    Map<String, Integer> process(List<FruitsTranslation> transactions);
}
