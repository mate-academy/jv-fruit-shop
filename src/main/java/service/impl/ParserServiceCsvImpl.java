package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceCsvImpl implements ParserService {
    private static final int INDEX_OF_TYPE_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String row) {
        String[] lineFields = row.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByCode(lineFields[INDEX_OF_TYPE_OPERATION]));
        fruitTransaction.setFruitName(lineFields[INDEX_OF_FRUIT_NAME]);
        fruitTransaction.setFruitQuantity(Integer.parseInt(lineFields[INDEX_OF_FRUIT_QUANTITY]));
        return fruitTransaction;
    }
}
