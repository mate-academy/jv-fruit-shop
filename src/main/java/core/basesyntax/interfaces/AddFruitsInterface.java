package core.basesyntax.interfaces;

import java.util.List;

public interface AddFruitsInterface<T> {
    List<T> fruitsAdd(T fruitsFromFile, List<T> fruitsAvailable);

    List<String> fruitsAddaLL(List<String> fruitsAvailable);
}
