package core.basesyntax.service;

import java.util.List;

public interface Parser<T> {
    List<T> parseLine(List<String> lines);
}
