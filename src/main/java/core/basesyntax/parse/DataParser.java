package core.basesyntax.parse;

import java.util.List;

public interface DataParser<T> {
    List<T> parse(List<String[]> data);
}
