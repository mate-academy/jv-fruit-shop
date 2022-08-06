package core.basesyntax.service.data;

import java.util.List;

public interface DataService<T> {
    void processData(List<T> list);
}
