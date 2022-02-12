package fruitshop.database;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
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
            switch (temp[0]) {
                case "b":
                    transactionDao.add(FruitTransaction.of(Operation.BALANCE,
                            temp[1], Integer.parseInt(temp[2])));
                    break;
                case "s":
                    transactionDao.add(FruitTransaction.of(Operation.SUPPLY,
                            temp[1], Integer.parseInt(temp[2])));
                    break;
                case "r":
                    transactionDao.add(FruitTransaction.of(Operation.RETURN,
                            temp[1], Integer.parseInt(temp[2])));
                    break;
                default:
                    transactionDao.add(FruitTransaction.of(Operation.PURCHASE,
                            temp[1], Integer.parseInt(temp[2])));
            }
        }
        return transactionDao;
    }
}
