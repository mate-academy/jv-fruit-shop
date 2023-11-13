package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int SKIP_TITLE = 1;
    private static final String COMMA = ",";
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .skip(SKIP_TITLE)
                .map(this::getTransactionFromCsv)
                .collect(Collectors.toList());

    }

    private FruitTransaction getTransactionFromCsv(String line) {
        String[] array = line.split(COMMA);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperationByCode(array[OPERATION_POSITION]));
        fruitTransaction.setFruit(array[FRUIT_POSITION]);
        fruitTransaction.setQuantity(Integer.parseInt(array[QUANTITY_POSITION]));
        return fruitTransaction;
    }
}
