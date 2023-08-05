package core.basesyntax.service;

import java.util.List;

public interface ParserService<T> {
    List<T> parser(List<String> inputData);
}
