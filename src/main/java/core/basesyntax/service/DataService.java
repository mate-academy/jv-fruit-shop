package core.basesyntax.service;

import java.util.List;

public interface DataService<T> {
    void processData(List<T> list);
}
