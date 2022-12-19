package service;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class ParseServiceImpl implements ParseService {
    private static final String SEPARATOR = ",";
    private static final String ONLY_NUMERIC = "^[0-9]+$";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        return strings.stream()
                .map(s -> s.split(SEPARATOR))
                .map(this::getFruitTransaction)
                .filter(fruitTransaction -> fruitTransaction.getOperation() != null)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String[] strings) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByCode(strings[OPERATION_INDEX]));
        fruitTransaction.setFruit(strings[FRUIT_INDEX]);
        fruitTransaction.setQuantity(isNumber(strings[QUANTITY_INDEX])
                ? Integer.parseInt(strings[QUANTITY_INDEX]) : 0);
        return fruitTransaction;
    }

    private boolean isNumber(String str) {
        return str.matches(ONLY_NUMERIC);
    }
}
