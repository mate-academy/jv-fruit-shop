package service;

import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    List<String[]> doReport();

    void fill(List<FruitTransaction> transactions);
}
