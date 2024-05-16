package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {
    public static final List<FruitTransaction> fruits = new ArrayList<>();
    public static final Set<String> fruitNames = new HashSet<>();
}
