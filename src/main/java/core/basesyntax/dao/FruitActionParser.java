package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitActionParser {
    List<FruitTransaction> parseAction(String[] activity);
}
