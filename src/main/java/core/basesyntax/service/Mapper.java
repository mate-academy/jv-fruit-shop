package core.basesyntax.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Mapper<F, T> {
    T map(F from);
    default List<T> mapAll(List<F> fromList) {
        return fromList.stream().map(this::map).collect(Collectors.toList());
    }
}
