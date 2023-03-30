package service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    public static final int INDEX_FOR_OPERATION = 0;
    public static final int INDEX_FOR_NAME_FRUIT = 1;
    public static final int INDEX_FOR_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransaction(List<String> list) {
        return list.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> Objects.equals(o.getCode(), fields[INDEX_FOR_OPERATION]))
                .findFirst()
                .get();
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[INDEX_FOR_NAME_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_FOR_QUANTITY]));
        return fruitTransaction;
    }
}
