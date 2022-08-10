package core.basesyntax.service.data;

import java.util.List;

public interface DataService<T> {
    List<?> processData(List<String> list);
}
