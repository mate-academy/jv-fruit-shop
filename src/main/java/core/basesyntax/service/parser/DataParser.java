package core.basesyntax.service.parser;

import java.util.List;

public interface DataParser<T> {
    List<T> pars(List<String> rawData);
}
