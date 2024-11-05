package core.basesyntax.db;

import java.util.Set;

public interface StockDao {
    void set(String product, Integer amount);

    Integer get(String product);

    void decrease(String product, Integer amount);

    void increase(String product, Integer amount);

    boolean contain(String product);

    Set<String> getProductsList();

}
