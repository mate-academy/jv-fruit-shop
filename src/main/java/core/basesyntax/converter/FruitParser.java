package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitParser {
    List<FruitTransaction> parseFruitTransaction(List<String> fruit);
}
