package core.basesyntax.service;

import java.util.List;

public interface ParseData<T> {
    List<T> parse(List<String> date);
}
