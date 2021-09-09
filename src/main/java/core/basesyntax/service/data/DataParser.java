package core.basesyntax.service.data;

import core.basesyntax.model.Operation;
import java.util.List;

public interface DataParser<T, U> {
    List<T> formatData(List<U> data);
}
