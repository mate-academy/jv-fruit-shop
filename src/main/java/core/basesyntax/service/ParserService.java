package core.basesyntax.service;

import java.util.List;

public interface ParserService<T> {
    List<T> parse(List<String> stringList);
}
