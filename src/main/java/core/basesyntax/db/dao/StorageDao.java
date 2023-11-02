package core.basesyntax.db.dao;

import java.util.Map;

public interface StorageDao {
    Integer getQuantityGoods(String goods);

    void setQuantityGoods(String goods, Integer newQuantity);

    Map<String, Integer> getStock();
}
