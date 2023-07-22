package core.basesyntax.db;

import java.util.List;

public interface Storage<T> {
    List<T> getStorage();

    void setStorage(List<T> storage);
}
