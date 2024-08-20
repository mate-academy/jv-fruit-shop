package service.shop;

import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    void process(List<FruitTransaction> process);
}
