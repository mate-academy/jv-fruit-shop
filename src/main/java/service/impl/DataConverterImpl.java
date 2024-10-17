package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final int HEADER_INDEX = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> fileData) {
        return fileData.stream()
                .skip(HEADER_INDEX)
                .map(this::createFruitTransactionInstance)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransactionInstance(String lineFromFile) {
        String[] fields = lineFromFile.split(SEPARATOR);
        return new FruitTransaction(fields[OPERATION_TYPE_INDEX].trim(),
                fields[FRUIT_TYPE_INDEX], Integer.parseInt(fields[QUANTITY_INDEX]));
    }
}
