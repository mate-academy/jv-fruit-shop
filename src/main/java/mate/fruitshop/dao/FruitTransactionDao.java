package mate.fruitshop.dao;

import java.util.List;
import mate.fruitshop.model.FruitTransaction;

public interface FruitTransactionDao {
    List<FruitTransaction> getAll();

    void saveReport(String report);
}
