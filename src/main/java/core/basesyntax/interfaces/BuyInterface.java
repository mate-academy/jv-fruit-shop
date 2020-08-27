package core.basesyntax.interfaces;

import java.util.List;

public interface BuyInterface<T> {
    List<T> buying(T fruitsFromFile) throws Exception;
}
