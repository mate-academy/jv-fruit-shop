package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StringListToFruitListConverter {
    List<FruitTransaction> parseList(List<String> fruit);
}
