package fruitshop.database;

import fruitshop.model.FruitTransaction;
import fruitshop.model.SaveData;
import java.util.ArrayList;
import java.util.List;

public class TransactionService implements SaveData {

    @Override
    public List<FruitTransaction> transactionData(List<String> readFile) {
        List<FruitTransaction> transactionDao = new ArrayList<>();
        String[] temp;
        readFile.remove(0);
        for (String line : readFile) {
            temp = line.split(",");
            transactionDao.add(FruitTransaction.of(temp[0], temp[1], Integer.parseInt(temp[2])));
        }
        return transactionDao;
    }
}
