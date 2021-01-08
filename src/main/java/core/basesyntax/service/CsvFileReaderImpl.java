package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String DIVIDER = ",";
    private static final Integer OPERATION_POSITION = 0;
    private static final Integer FRUIT_NAME_POSITION = 1;
    private static final Integer QUANTITY_POSITION = 2;

    @Override
    public List<TransactionDto> read(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("test-fruit.csv");
        List<TransactionDto> dtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String temp = reader.readLine();
            while (temp != null) {
                dtos.add(convertToTransaction(temp));
                temp = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file: " + fileName);
        }
        return dtos;
    }

    private TransactionDto convertToTransaction(String csvRow) {
        String[] fields = csvRow.split(DIVIDER);
        return new TransactionDto(Operation.getInstanceFromString(fields[OPERATION_POSITION]),
                new Fruit(fields[FRUIT_NAME_POSITION]),
                Integer.parseInt(fields[QUANTITY_POSITION]));
    }
}
