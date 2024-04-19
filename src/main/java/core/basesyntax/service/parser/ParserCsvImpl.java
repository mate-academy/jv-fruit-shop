package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserCsvImpl implements ParserCsv {
    private static final String DELLIMETER = ",";
    private static final Integer FRUIT_OPERATION_INDEX = 0;
    private static final Integer FRUIT_NAME_INDEX = 1;
    private static final Integer FRUIT_QUANTITY_INDEX = 2;
    @Override
    public List<FruitTransaction> parseTransactions (List<String> transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        List<String[]> parsedTransactions = convertTransactions(transactions);
        for (String[] element : parsedTransactions) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(getOperation(element[FRUIT_OPERATION_INDEX]));
            fruitTransaction.setFruit(element[FRUIT_NAME_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(element[FRUIT_QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }

    public List<String[]> convertTransactions (List<String> transactions) {
        return transactions.stream()
                .skip(1)
                .map(el -> el.split(DELLIMETER))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("This type don`t exist: " + code);
    }
}
