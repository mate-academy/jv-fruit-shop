package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadScvService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadScvServiceImpl implements ReadScvService {
    private final String filePath = "input.csv";
    private final int operationColumnIndex = 0;
    private final int fruitColumnIndex = 1;
    private final int quantityColumnIndex = 2;

    @Override
    public List<FruitTransaction> readFromFileInputCsv() {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                FruitTransaction fruitTransaction = new FruitTransaction();
                String[] value = line.split((","));
                fruitTransaction.setOperation(FruitTransaction
                        .Operation.fromCode(value[operationColumnIndex]));
                fruitTransaction.setFruit(value[fruitColumnIndex]);
                fruitTransaction.setQuantity(Integer.parseInt(value[quantityColumnIndex]));
                fruitTransactions.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fruitTransactions;
    }
}
