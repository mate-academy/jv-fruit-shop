package core.basesyntax;

import java.util.List;

public interface DataConverter<T> {
    List<T> convertToTransaction(List<String[]> data);
}
