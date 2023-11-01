package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParser {
    List<FruitTransaction> parseData(List<String> data);
}
