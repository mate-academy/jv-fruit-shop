package core.basesyntax.service;

import java.util.Collection;

public interface WriterService<F, T> {
    void writeLines(Collection<F> data, T target);
}
