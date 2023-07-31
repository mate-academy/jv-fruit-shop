package core.basesyntax.service;

import java.util.List;

public interface FruitConverter<T> {
    List<T> convert(String string);
}
