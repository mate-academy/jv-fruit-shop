package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> read(String path) {
        List<FruitTransaction> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitedTransaction = line.split(SPLIT_SYMBOL);
                stringList.add(new FruitTransaction(
                        Operation.getByValue(splitedTransaction[OPERATION_INDEX]),
                        splitedTransaction[FRUIT_INDEX],
                        Integer.parseInt(splitedTransaction[QUANTITY_INDEX])));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + path, e);
        }
        return stringList;
    }
}
