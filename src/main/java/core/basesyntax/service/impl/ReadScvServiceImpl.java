package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadScvService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadScvServiceImpl implements ReadScvService {
    private final String FILE_PATH = "input.csv";
    private final int OPERATION_COLUMN_INDEX = 0;
    private final int FRUIT_COLUMN_INDEX = 1;
    private final int QUANTITY_COLUMN_INDEX = 2;

    @Override
    public List<FruitTransaction> readFromFileInputCsv() {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                FruitTransaction fruitTransaction = new FruitTransaction();
                String[] value = line.split((","));
                fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(value[OPERATION_COLUMN_INDEX]));
                fruitTransaction.setFruit(value[FRUIT_COLUMN_INDEX]);
                fruitTransaction.setQuantity(Integer.parseInt(value[QUANTITY_COLUMN_INDEX]));
                fruitTransactions.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fruitTransactions;
    }
}
