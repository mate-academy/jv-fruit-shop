package core.basesyntax.reader;

import java.util.List;

public interface Reader<T> {
    List<T> readFile();
}
