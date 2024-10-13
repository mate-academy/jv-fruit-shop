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
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = lineFromFile.split(",");
        fruitTransaction.setOperation(fields[ZERO_ELEMENT].trim());
        fruitTransaction.setFruit(fields[ONE_ELEMENT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[TWO_ELEMENT]));
        return fruitTransaction;
    }
}
