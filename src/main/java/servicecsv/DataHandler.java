package servicecsv;

import java.util.List;
import model.FruitTransaction;

public interface DataHandler {
    void handleData(List<FruitTransaction> fruitTransactionList);
}
