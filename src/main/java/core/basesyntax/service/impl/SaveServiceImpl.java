package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.SaveService;
import java.util.ArrayList;
import java.util.List;

public class SaveServiceImpl implements SaveService {
    private static final String DELIMITER_BY_SENTENCE = ",";

    @Override
    public List<FruitTransaction> saveToDb(List<String> string) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] message;
        for (int i = 1; i < string.size(); i++) {
            message = string.get(i).split(DELIMITER_BY_SENTENCE);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(getOperation(message[0]));
            fruitTransaction.setFruit(message[1]);
            fruitTransaction.setQuantity(Integer.parseInt(message[2]));
            transactions.add(fruitTransaction);
        }
        Storage.storage.addAll(transactions);
        return transactions;
    }

    private FruitTransaction.Operation getOperation(String operation) {
        switch (operation) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new RuntimeException("Don`t have this category: " + operation);
        }
    }
}
