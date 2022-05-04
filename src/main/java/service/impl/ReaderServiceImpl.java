package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> read(String path) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitedTransaction = line.split(SPLIT_SYMBOL);
                fruitTransactions.add(new FruitTransaction(
                        FruitTransaction.Operation.getByValue(splitedTransaction[OPERATION_INDEX]),
                        splitedTransaction[FRUIT_INDEX],
                        Integer.parseInt(splitedTransaction[QUANTITY_INDEX])));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + path, e);
        }
        return fruitTransactions;
    }
}
