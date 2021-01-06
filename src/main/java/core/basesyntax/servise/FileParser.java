package core.basesyntax.servise;

import java.util.List;

public interface FileParser<T> {
    List<T> parseData(List<String> list);
}
