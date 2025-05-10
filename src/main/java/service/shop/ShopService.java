package service.shop;

import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    void handleTransactionList(List<FruitTransaction> process);
}
