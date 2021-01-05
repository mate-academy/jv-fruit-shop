package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionMapperImpl implements TransactionMapper {
    private List<Transaction> transactions = new ArrayList<>();
    private List<String> reportToStrings = new ArrayList<>();

    @Override
    public List<Transaction> stringsToTransactions(List<String> transStrings) {
        for (String s : transStrings) {
            transactions.add(stringToTransaction(s));
        }
        return transactions;
    }

    @Override
    public List<String> storageToStrings(Map<Fruit, Integer> storage) {
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            reportToStrings.add(entry.getKey().getName() + ", " + entry.getValue());
        }
        return reportToStrings;
    }

    private Transaction stringToTransaction(String row) {
        Transaction transaction = new Transaction();
        String[] parsRow = row.split(",");
        transaction.setOperation(Operation.getOperation(parsRow[0]));
        transaction.setFruit(new Fruit(parsRow[1]));
        int quantity = Integer.parseInt(parsRow[2]);
        if (quantity >= 0) {
            transaction.setQuantity(Integer.parseInt(parsRow[2]));
        } else {
            throw new IllegalArgumentException("Can't apply negative quantity " + quantity);
        }
        return transaction;
    }
}
