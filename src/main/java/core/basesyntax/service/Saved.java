package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Saved {
    List<FruitTransaction> saveToDb(String string);
}
