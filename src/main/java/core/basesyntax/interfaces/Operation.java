package core.basesyntax.interfaces;

import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.model.Fruit;
import core.basesyntax.operations.Transaction;
import java.util.List;

public interface Operation {
    public List<Fruit> apply(Transaction fruitsFromFile) throws NotEnoughFruitsException;
}
