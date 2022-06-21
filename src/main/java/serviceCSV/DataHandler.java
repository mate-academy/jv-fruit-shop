package serviceCSV;

import model.FruitTransaction;

import java.util.List;

public interface DataHandler {
    void handleData(List<FruitTransaction> fruitTransactionList);
}
