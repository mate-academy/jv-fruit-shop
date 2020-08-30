package core.basesyntax.services;

import core.basesyntax.exceptions.WrongTypeException;
import core.basesyntax.parsers.ParseToFile;
import core.basesyntax.transactions.Transaction;
import java.time.LocalDate;
import java.util.Map;

public class Buy implements StorageOperation {

    @Override
    public boolean updateTransactionTable(String filePath, String type,
                                          Integer quantity, LocalDate expirationDate) {
        Map<String, Integer> balanceSheet = new BalanceSheet().getBalanceMap(filePath);
        if (balanceSheet.containsKey(type)) {
            balanceSheet.containsKey(type);
            int existingFruitQuantity = balanceSheet.get(type);
            if (existingFruitQuantity >= quantity) {
                Transaction transaction = new Transaction("b", type,
                        quantity * (-1), expirationDate);
                new ParseToFile().writeToFile(transaction, filePath);
                return true;
            } else {
                return false;
            }
        }
        throw new WrongTypeException("Fruit type not presented in the storage");
    }
}
