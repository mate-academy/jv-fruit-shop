package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.io.File;
import java.util.List;

public interface FruitDao {
//    int get (String nameOfFruit);
    List<FruitTransaction> getAll(File file);
}
