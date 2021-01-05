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
    private static final String SPLITTER = ",";
    private static final int TYPE_OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<TransactionDto> readData(String fileName) {
        List<TransactionDto> dtoList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            value = bufferedReader.readLine();
            while (value != null) {
                String[] transaction = value.split(SPLITTER);
                TransactionDto transactionDto =
                        new TransactionDto(Operation.fromString(transaction[TYPE_OPERATION]),
                                new Fruit(transaction[FRUIT_NAME]),
                                Integer.valueOf(transaction[QUANTITY]));
                dtoList.add(transactionDto);
                value = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file! " + fileName);
        }
        return dtoList;
    }
}
