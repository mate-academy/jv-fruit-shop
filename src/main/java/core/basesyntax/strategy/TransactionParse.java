package core.basesyntax.strategy;

import core.basesyntax.model.FruitsTranslation;
import java.util.List;

public interface TransactionParse {
    List<FruitsTranslation> parseData(List<String> fruitOperations);
}
