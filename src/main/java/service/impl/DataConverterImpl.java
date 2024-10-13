package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int ZERO_ELEMENT = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int TWO_ELEMENT = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> fileData) {
        return fileData.stream()
                .skip(1)
                .map(this::createFruitTransactionInstance)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransactionInstance(String lineFromFile) {
        String[] fields = lineFromFile.split(",");
        return new FruitTransaction(fields[ZERO_ELEMENT].trim(),
                fields[ONE_ELEMENT], Integer.parseInt(fields[TWO_ELEMENT]));
    }
}
