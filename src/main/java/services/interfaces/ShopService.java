package services.interfaces;

import java.io.IOException;
import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactions) throws IOException;
}
