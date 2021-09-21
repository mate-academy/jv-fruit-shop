package core.basesyntax.services.data;

import java.util.List;

public interface DataParser<T, U> {
    List<T> formatData(List<U> data);
}
