package core.basesyntax.model.shopdao;

import core.basesyntax.model.shopstrategy.ShopActions;
import java.util.List;

public interface ShopDao {
    
    List<String> getAllActions();
    
    int getItemActions(String item);
    
    void addAction(ShopActions action, String item, int amount);
    
    void close();
}
