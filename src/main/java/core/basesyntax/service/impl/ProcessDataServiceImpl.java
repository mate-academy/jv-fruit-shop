package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProcessDataServiceImpl implements ProcessDataService {
    private static final int FIRST_LINE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final String LINE_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<String> readData(String filePath) {
        File file = new File(filePath);
        List<String> inputData;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            inputData = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return inputData;
    }

    @Override
    public List<FruitTransaction> saveData(List<String> inputData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        inputData.remove(FIRST_LINE_INDEX);
        for (String line : inputData) {
            String[] data = line.split(LINE_SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(
                    FruitTransaction.Operation.getType(data[OPERATION_INDEX]));
            fruitTransaction.setFruitName(data[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
