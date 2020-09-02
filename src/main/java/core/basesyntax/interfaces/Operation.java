package core.basesyntax.interfaces;

import core.basesyntax.model.Fruit;
import core.basesyntax.operations.Transaction;
import java.util.List;

public interface Operation {
    List<Fruit> apply(Transaction fruitsFromFile);
}
