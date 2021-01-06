package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ParserCsvFile implements Parser<TransactionDto> {
    private static final String PARSE_BY = ",";
    private static final int COUNT_OF_PARSE = 3;
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int COUNT = 2;

    @Override
    public List<TransactionDto> parseCsvFile(List<String> inputData) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        inputData.remove(0);
        for (String line : inputData) {
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
            if (operation.equalsIgnoreCase(value.getOperation())) {
                return value;
            }
        }
        throw new NoSuchElementException(String.format("%s operation not found", operation));
    }
}
