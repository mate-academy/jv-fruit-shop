package core.basesyntax.service.reader;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionStrategy;
import core.basesyntax.service.FruitTransactionStrategyImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceICsvImpl implements ReaderService {
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
    private FruitTransactionStrategy fruitTransactionStrategy = new FruitTransactionStrategyImpl();

    @Override
    public void readFromFile(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String value = reader.readLine();
            while (value != null) {
                String[] data = value.split(",");
                FruitTransaction fruitTransaction = new FruitTransaction();
                fruitTransaction.setOperation(getType(data[0]));
                fruitTransaction.setFruit(data[1]);
                fruitTransaction.setQuantity(Integer.parseInt(data[2]));
                fruitTransactionStrategy.typeOperation(fruitTransaction);
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file: " + inputFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + inputFile, e);
        }
    }

    private FruitTransaction.Operation getType(String operation) {
        switch (operation) {
            case "b" :
                return FruitTransaction.Operation.BALANCE;
            case "s" :
                return FruitTransaction.Operation.SUPPLY;
            case "p" :
                return FruitTransaction.Operation.PURCHASE;
            case "r" :
                return FruitTransaction.Operation.RETURN;
            default:
                throw new RuntimeException("can't find according type of operation");
        }
    }
}
