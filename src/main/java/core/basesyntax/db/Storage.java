package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<FruitTransaction> fruitTransactions = new ArrayList<>();
    public static final List<Fruit> fruits = new ArrayList<>();
}
