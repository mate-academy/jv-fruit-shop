package core.basesyntax.dao;

import core.basesyntax.model.fruit.Record;
import java.util.List;

public interface ReadDao {
    List<Record> read();
}
