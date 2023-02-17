package core.basesyntax.strategy.filestrategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParser {
    List<FruitTransaction> parseData(String data);
}
