package core.basesyntax.model.shopdao;

import java.util.List;

public interface ShopDto<R> {
    List<R> getTransactionHistory();
    
    List<R> getItemTransactionHistory(String item);
    
    void addTransaction(R action);
    
    void addAll(List<R> lines);
}
