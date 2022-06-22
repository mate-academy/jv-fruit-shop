package core.basesyntax.service;

import java.util.List;

public interface InputDataMapper<T> {
    List<T> map(List<String> lineData);
}
