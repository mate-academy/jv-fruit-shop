package core.basesyntax.dao;

import java.util.Set;

public interface Dao {
    Integer get(String product);

    Integer put(String product, Integer amount);

    boolean contains(String product);

    Integer remove(String product);

    Set<String> getProductNames();
}
