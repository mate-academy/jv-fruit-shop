package core.basesyntax.db.csv;

import java.util.List;

public interface Writer<T> {
    void writeAll(List<T> record);
}
