package core.basesyntax.dao;

import java.util.Map;
import java.util.Optional;

public interface ProductStorageDao {
    void setQuantity(String productName, Integer productQuantity);

    Optional<Integer> getQuantity(String productName);

    Map<String, Integer> getAll();
}
