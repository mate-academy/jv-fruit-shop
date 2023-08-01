package core.basesyntax.service.implemantation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParseData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDateImpl implements ParseData<FruitTransaction> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int INFORMATION_LINE_INDEX = 0;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactions;
        data.remove(INFORMATION_LINE_INDEX);
        fruitTransactions = data.stream()
                .map(line -> line.split(","))
                .map(transactions ->
                        new FruitTransaction(getOperationByCod(transactions[OPERATION_INDEX]),
                                transactions[FRUIT_INDEX],
                                Integer.parseInt(transactions[QUANTITY_INDEX]))).collect(Collectors.toList());
        return fruitTransactions;
    }

    private Operation getOperationByCod(String operationCode) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(operationCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid operation code: " + operationCode));
    }

}
