package core.basesyntax.servise.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> readFromCsv(String filePath) {
        File file = new File(filePath);
        List<String> dataFromCsv;
        try {
            dataFromCsv = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: " + file, e);
        }
        return dataFromCsv.stream()
                .skip(1)
                .map(this::getDataFromCsv)
                .collect(Collectors.toList());
    }

    private FruitTransaction getDataFromCsv(String csvData) {
        String[] storeData = csvData.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperation(storeData[OPERATION_INDEX]));
        fruitTransaction.setFruit(storeData[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(storeData[AMOUNT_INDEX]));
        return fruitTransaction;
    }
}
