package core.basesyntax.service.data;

import java.util.List;

public interface DataParserImpl<T, V> {
    List<T> formatData(List<V> data);
}
