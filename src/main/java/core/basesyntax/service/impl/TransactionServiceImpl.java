package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransactionServiceImpl implements TransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SIGN_TO_SPLIT = ",";

    @Override
    public List<FruitTransaction> processData(List<String> rawDataFromFile) {
        return IntStream.range(1, rawDataFromFile.size())
                .mapToObj(i -> processLine(rawDataFromFile.get(i)))
                .collect(Collectors.toList());
    }

    private FruitTransaction processLine(String line) {
        String[] dataArr = line.split(SIGN_TO_SPLIT);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(fruitTransaction.getOperationType(dataArr[OPERATION_INDEX]));
        fruitTransaction.setFruitType(dataArr[FRUIT_TYPE_INDEX]);
        fruitTransaction.setAmount(Math.abs(Integer.parseInt(dataArr[AMOUNT_INDEX])));
        return fruitTransaction;
    }
}
