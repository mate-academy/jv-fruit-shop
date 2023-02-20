package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderServiceImpl implements ReaderService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int OPERATION_VALUE_INDEX = 2;
    private final FruitTransactionDao fruitTransactionDao;

    public ReaderServiceImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void readFromFileIntoStorage(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                FruitTransaction transaction = new FruitTransaction();
                transaction.setOperation(FruitTransaction.Operation.of(data[OPERATION_TYPE_INDEX]));
                transaction.setFruit(new Fruit(data[FRUIT_NAME_INDEX]));
                transaction.setQuantity(Integer.parseInt(data[OPERATION_VALUE_INDEX]));
                fruitTransactionDao.add(transaction);

                line = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading a file", e);
        }
    }
}
