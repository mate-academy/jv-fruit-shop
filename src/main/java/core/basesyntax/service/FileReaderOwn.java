package core.basesyntax.service;

import java.util.List;

public interface FileReaderOwn<T> {
    List<T> read(String filePath);
}
