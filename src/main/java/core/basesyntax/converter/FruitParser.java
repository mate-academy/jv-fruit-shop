package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitParser {
    List<FruitTransaction> parseList(List<String> fruit);
}
