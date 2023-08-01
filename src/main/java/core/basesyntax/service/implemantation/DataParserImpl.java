package core.basesyntax.service.implemantation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int INFORMATION_LINE_INDEX = 0;
    private static final String SPLIT_SYMBOL = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactions;
        data.remove(INFORMATION_LINE_INDEX);
        fruitTransactions = data.stream()
                .map(line -> line.split(SPLIT_SYMBOL))
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
        return fruitTransactions;
    }


    private Operation getOperationByCode(String operationCode) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(operationCode))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Invalid operation code: " + operationCode));
    }

    private FruitTransaction getFruitTransaction(String[] transactions) {
        Operation operation = getOperationByCode(transactions[OPERATION_INDEX]);
        String fruitName = transactions[FRUIT_INDEX];
        int quantity = Integer.parseInt(transactions[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruitName, quantity);
    }
}
