package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessorImpl implements DataProcessor {
    private static final String COMA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactions(List<String> linesFormFile) {
        linesFormFile = skipFirstLine(linesFormFile);
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        String[] splitedLine = null;
        for (String line : linesFormFile) {
            splitedLine = line.split(COMA_SEPARATOR);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(getOperation(splitedLine[OPERATION_INDEX]),
                    splitedLine[FRUIT_INDEX], Integer.parseInt(splitedLine[QUANTITY_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

    private List<String> skipFirstLine(List<String> linesFromFile) {
        return linesFromFile.stream()
                            .skip(1)
                            .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String operationCode) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(operationCode)) {
                return operation;
            }
        }
        throw new RuntimeException("No such operation by code:" + operationCode);
    }
}
