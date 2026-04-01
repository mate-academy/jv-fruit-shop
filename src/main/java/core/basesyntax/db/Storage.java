package core.basesyntax.db;

import core.basesyntax.model.Accountable;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Accountable> fruits = new ArrayList<>();

    public static List<Accountable> getFruits() {
        return fruits;
    }
}
