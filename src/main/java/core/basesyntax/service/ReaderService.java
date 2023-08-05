package core.basesyntax.service;

import java.util.List;

public interface ReaderService<T> {
    List<T> readFromFile(String addressFile, List<String> data);
}
