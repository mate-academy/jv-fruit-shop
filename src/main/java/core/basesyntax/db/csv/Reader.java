package core.basesyntax.db.csv;

import java.util.List;

public interface Reader<T> {
    List<T> readAll();
}
