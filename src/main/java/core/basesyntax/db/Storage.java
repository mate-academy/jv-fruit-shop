package core.basesyntax.db;

import java.util.Set;

public interface Storage {
    Integer getAmount(String product);
    Integer setAmount(String product, Integer amount);
    boolean contains(String product);
    Integer remove(String product);
    Integer put(String product, Integer amount);
    Set<String> getProductNames();
}
