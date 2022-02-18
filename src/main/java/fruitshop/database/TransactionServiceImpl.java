package fruitshop.database;

import fruitshop.model.FruitTransaction;
import fruitshop.model.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<FruitTransaction> transactionData(List<String> readFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] temp;
        readFile.remove(0);
        for (String line : readFile) {
            temp = line.split(",");
            transactions.add(FruitTransaction.of(temp[0],temp[1],Integer.parseInt(temp[2])));
        }
        return transactions;
    }
}
