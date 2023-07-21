package core.basesyntax.service;

import java.util.List;

public interface StringToListService<T> {
    List<T> convert(String string);
}
