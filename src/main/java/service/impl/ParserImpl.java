package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.Parser;

public class ParserImpl implements Parser {
    private static final int FIRST_STRING_INDEX = 0;
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parseData(List<String> input) {
        input.remove(FIRST_STRING_INDEX);
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        input.stream()
                .map(s -> s.split(SPLITERATOR))
                .forEach(strings -> fruitTransactionList
                        .add(new FruitTransaction(
                                FruitTransaction.findOperationByLetter(strings[OPERATION_INDEX]),
                                strings[FRUIT_NAME_INDEX],
                                Integer.parseInt(strings[QUANTITY_INDEX]))));
        return fruitTransactionList;
    }
}
