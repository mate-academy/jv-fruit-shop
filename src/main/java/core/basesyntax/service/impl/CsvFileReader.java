package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CsvFileReader implements FileReader {
    private static final String PARSE_BY = ",";
    private static final int COUNT_OF_PARSE = 3;
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int COUNT = 2;

    @Override
    public List<TransactionDto> readData(String filePath) {
        List<String> listOfInformation = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            while (reader.ready()) {
                listOfInformation.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("The problem has been encountered "
                    + "while reading file %s.)", filePath), e);
        }
        listOfInformation.remove(0);
        return convertListOfLinesToTransactionDtoList(listOfInformation);
    }

    private List<TransactionDto> convertListOfLinesToTransactionDtoList(List<String> data) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (String line : data) {
            String[] arrayOfData = line.split(PARSE_BY);
            if (arrayOfData.length != COUNT_OF_PARSE) {
                throw new NoSuchElementException(
                        String.format("Elements in line %d, but must be %d",
                                arrayOfData.length, COUNT_OF_PARSE));
            }
            transactionDtos.add(createTransactionDto(arrayOfData));
        }
        return transactionDtos;
    }

    private TransactionDto createTransactionDto(String[] data) {
        for (String value : data) {
            if (value == null || value.length() == 0) {
                throw new NoSuchElementException("Elements cannot be null");
            }
        }
        return new TransactionDto(checkAndGetOperation(data[OPERATION]),
                new Fruit(data[FRUIT]), Integer.parseInt(data[COUNT]));
    }

    private Operation checkAndGetOperation(String operation) {
        for (Operation value : Operation.values()) {
            if (operation != null && operation.equalsIgnoreCase(operation)) {
                return value;
            }
        }
        throw new NoSuchElementException(String.format("%s operation not found", operation));
    }
}
