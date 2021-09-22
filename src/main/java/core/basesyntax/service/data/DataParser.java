package core.basesyntax.service.data;

import java.util.List;

public interface DataParser<T, V> {
    List<T> formatData(List<V> data);
}
