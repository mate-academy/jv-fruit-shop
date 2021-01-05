package core.basesyntax.parse;

import java.util.List;

public interface ParseFruit<T> {
    List<T> parse(List<String[]> data);
}
