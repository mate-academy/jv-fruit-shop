package fruit.shop.dao;

import java.util.List;

public interface ShopDao {

    List<String> read();
    boolean write(String lines);
}
