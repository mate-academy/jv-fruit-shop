package core.basesyntax.service.parser;

import java.util.List;

public interface DataParser<T> {
    void parseData(List<T> data);
}
