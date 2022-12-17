package service;

import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    boolean processTransactions(List<FruitTransaction> transactions);

}
