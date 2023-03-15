package core.basesyntax.service;

import java.util.List;

public interface ReaderService<F, T> {
    List<T> readLines(F source);
}
