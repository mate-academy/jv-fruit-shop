package core.service;

import core.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transaction);
}
