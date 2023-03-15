package core.basesyntax.service;

import java.util.List;

public interface Reader<F, T> {
    List<T> readLines(F source);
}
