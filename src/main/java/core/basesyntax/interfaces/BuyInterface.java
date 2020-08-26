package core.basesyntax.interfaces;

import java.util.List;

public interface BuyInterface<T> {
    List<T> buying(List<T> fruitsAvailable, T fruitsFromFile) throws Exception;
}
