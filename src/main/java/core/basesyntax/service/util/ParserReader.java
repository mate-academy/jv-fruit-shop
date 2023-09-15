package core.basesyntax.service.util;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserReader {
    List<FruitTransaction> parsedToFruitTransaction(List<String> fromFile);
}
