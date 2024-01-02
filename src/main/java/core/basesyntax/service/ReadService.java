package core.basesyntax.service;

import java.util.List;

public interface ReadService<T> {
    List<T> read(String filePath);
}
