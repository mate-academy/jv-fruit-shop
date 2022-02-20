package core.basesyntax.services;

import java.util.List;

public interface Parser<T> {
    List<T> parse(List<String> lines);
}
