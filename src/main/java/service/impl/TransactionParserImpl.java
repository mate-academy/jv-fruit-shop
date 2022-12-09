package service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> fruitTransactions) {
        Predicate<String> transactionPredicate = s -> s.split(COMMA)[OPERATION_INDEX].length() == 1
                && Character.isLetter(s.charAt(OPERATION_INDEX));
        return fruitTransactions.stream()
                .filter(transactionPredicate)
                .map(s -> createFruitTransaction(s.split(COMMA)))
                .collect(toList());
    }

    private FruitTransaction createFruitTransaction(String[] splitString) {
        return new FruitTransaction(model.Operation
                .getByCode(splitString[OPERATION_INDEX]),
                splitString[FRUIT_INDEX], Integer.parseInt(splitString[QUANTITY_INDEX]));
    }
}
