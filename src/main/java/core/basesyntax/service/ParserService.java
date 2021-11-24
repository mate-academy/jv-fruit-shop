package core.basesyntax.service;

import java.util.List;

public interface ParserService<T> {
    List<T> parseLines(List<String> list);
}
