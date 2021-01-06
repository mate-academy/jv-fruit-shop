package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<TransactionDto> readData(String fileName) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                String[] split = row.split(",");

                transactionDtoList.add(parseDateFromFile(split));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return transactionDtoList;
    }

    private TransactionDto parseDateFromFile(String[] transaction) {
        if (Integer.parseInt(transaction[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("We can't work with negative number");
        }
        TransactionDto currentTransaction = new TransactionDto();
        currentTransaction.setOperation(Operation.fromString(transaction[OPERATION_INDEX]));
        currentTransaction.setFruit(new Fruit(transaction[FRUIT_INDEX]));
        currentTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY_INDEX]));
        return currentTransaction;
    }
}
