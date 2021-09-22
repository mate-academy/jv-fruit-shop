package core.basesyntax.service;

import java.util.List;

public interface Transformation<T, U> {
    List<U> transformationToObj(List<T> value);
}
