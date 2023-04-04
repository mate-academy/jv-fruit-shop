package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int NUMBER_OF_FIRST_LINE = 1;
    private static final int INDEX_FOR_OPERATION = 0;
    private static final int INDEX_FOR_NAME_FRUIT = 1;
    private static final int INDEX_FOR_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> list) {
        return list.stream()
                .skip(NUMBER_OF_FIRST_LINE)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .getByCode(fields[INDEX_FOR_OPERATION]);
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[INDEX_FOR_NAME_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_FOR_QUANTITY]));
        return fruitTransaction;
    }
}
