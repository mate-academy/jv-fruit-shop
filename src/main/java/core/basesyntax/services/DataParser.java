package core.basesyntax.services;

import java.util.List;

public interface DataParser<T> {
    List<T> parse(List<String> rawData);
}
