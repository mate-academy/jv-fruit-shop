package core.basesyntax.service.impl;

import core.basesyntax.model.Fruits;
import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements DataReader {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int DATA_TYPES_QUANTITY = 3;
    private static final int LOWER_BOUND_OF_BALANCE = 0;

    @Override
    public List<Transaction> read(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            List<Transaction> lineList = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                if (!line.contains("type")) {
                    lineList.add(dataLine(line));
                }
                line = bufferedReader.readLine();
            }
            return lineList;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file " + filename);
        }
    }

    private Transaction dataLine(String line) {
        String [] operationData = line.split(DELIMITER);
        if (operationData.length != DATA_TYPES_QUANTITY) {
            throw new RuntimeException("Wrong format of data from file");
        }
        String operation = operationData[OPERATION_INDEX];
        String fruit = operationData[FRUIT_INDEX];
        int amount = Integer.parseInt(operationData[AMOUNT_INDEX]);
        if (operation == null || operation.isEmpty() || fruit == null
                || fruit.isEmpty() || amount < LOWER_BOUND_OF_BALANCE) {
            throw new RuntimeException("Inappropriate argument in the line");
        }
        return new Transaction(Operations.checkOperation(operation.trim()),
                new Fruits(fruit), amount);
    }
}
