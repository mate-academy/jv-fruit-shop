package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.File;
import java.util.List;

public interface FruitDao {
    List<FruitTransaction> getAll(File file);
}
