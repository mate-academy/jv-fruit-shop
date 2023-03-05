package core.basesyntax.service.impl;

import core.basesyntax.db.FruitsTransactions;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderImpl implements Reader {
    private static final String DELIMITER = ",";

    @Override
    public void readerTransaction(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader((new FileReader(fileName)))) {
            String text = bufferedReader.readLine();
            text = bufferedReader.readLine();
            while (text != null) {
                addFruitTransaction(text);
                text = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`open file" + fileName, e);
        }
    }

    private void addFruitTransaction(String string) {
        String[] elements = string.split(DELIMITER);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(getOperation(elements[0]));
        fruitTransaction.setFruit(elements[1]);
        fruitTransaction.setQuantity(Integer.parseInt(elements[2]));
        FruitsTransactions.Storage.add(fruitTransaction);
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
