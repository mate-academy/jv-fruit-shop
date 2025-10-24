package interfaces;

import java.util.List;
import service.impl.FruitTransaction;

public interface ShopService {
    public void process(List<FruitTransaction> transactions);
}
