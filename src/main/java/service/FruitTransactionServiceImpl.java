package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import util.ValidationDataException;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String SPLIT_REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (String transaction : transactions) {
            FruitTransaction fruitTransaction = extractTransaction(transaction);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }

    private FruitTransaction extractTransaction(String line) {
        String[] parts = line.split(SPLIT_REGEX);

        if (parts.length != 3) {
            throw new ValidationDataException(
                    "Invalid input format in file");
        }

        FruitTransaction transaction = new FruitTransaction();

        try {
            transaction.setOperation(
                    FruitTransaction.Operation.fromCode(
                            parts[OPERATION_INDEX].trim()));
        } catch (IllegalArgumentException e) {
            throw new ValidationDataException(
                    "Invalid operation code in file");
        }

        transaction.setFruit(parts[FRUIT_INDEX]);

        try {
            transaction.setQuantity(Integer.parseInt(
                    parts[QUANTITY_INDEX].trim()));
        } catch (NumberFormatException e) {
            throw new ValidationDataException(
                    "Invalid quantity format in file");
        }

        return transaction;
    }
}
