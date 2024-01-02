package core.basesyntax.service;

import java.util.List;

public interface WriteService<T> {
    void write(List<T> data);
}
