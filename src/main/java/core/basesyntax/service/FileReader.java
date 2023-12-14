package core.basesyntax.service;

import java.util.List;

public interface FileReader<T> {
    List<T> parseDataFrom(String fileName);
}
