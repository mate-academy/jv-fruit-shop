package core.basesyntax.service;

import java.util.List;

public interface DataParser<T> {
    List<T> parse(List<String> fileData);
}
