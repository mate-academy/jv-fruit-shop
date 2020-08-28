package core.basesyntax.services;

import core.basesyntax.parsers.ParseToCSV;
import core.basesyntax.parsers.Transaction;

import java.time.LocalDate;
import java.util.Map;

public class Buy implements StorageOperation {

    @Override
    public boolean UpdateTransactionTable(String FilePath, String type, Integer quantity, LocalDate expirationDate) {
        Map<String, Integer> map = new BalanceSheet().getBalanceMap(FilePath);
        boolean fruitTypeExists = map.containsKey(type);
        if (fruitTypeExists) {
            int existingFruitQuantity = map.get(type);
            if (existingFruitQuantity > quantity) {
                Transaction transaction = new Transaction("b", type, quantity, expirationDate);
                boolean addSupplyToCSV = new ParseToCSV().writeToFile(transaction, FilePath);
                return addSupplyToCSV;
            }
        }
        return false;
    }
}
