package core.basesyntax.interfaces;

import core.basesyntax.Fruit;
import core.basesyntax.Transaction;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import java.util.List;

public interface Operation {
    public List<Fruit> operation(List<Fruit> fruitsAvailable,
                                 Transaction fruitsFromFile) throws NotEnoughFruitsException;
}
