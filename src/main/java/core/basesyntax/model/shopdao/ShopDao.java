package core.basesyntax.model.shopdao;

import java.util.List;

public interface ShopDao<R> {
    List<R> getAllActions();
    
    List<R> getItemActions(String item);
    
    void addAction(R action);
    
    void update();
}
