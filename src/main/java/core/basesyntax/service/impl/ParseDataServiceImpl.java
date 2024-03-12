package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseDataService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private Map<String, FruitTransaction.Operation> operationMap = Map.of(
            FruitTransaction.Operation.BALANCE.getCode(), FruitTransaction.Operation.BALANCE,
            FruitTransaction.Operation.PURCHASE.getCode(), FruitTransaction.Operation.PURCHASE,
            FruitTransaction.Operation.RETURN.getCode(), FruitTransaction.Operation.RETURN,
            FruitTransaction.Operation.SUPPLY.getCode(), FruitTransaction.Operation.SUPPLY
    );

    @Override
    public List<FruitTransaction> parseData(String data) {
        List<FruitTransaction> fruitList = new ArrayList<>();
        String[] splitData = data.split(System.lineSeparator());
        List<String> dataWithoutTitle = Arrays.stream(splitData)
                .skip(1)
                .toList();
        for (String line : dataWithoutTitle) {
            String[] dataFruit = line.split(",");
            if (dataFruit.length != 3) {
                throw new RuntimeException("Data aren`t correct: " + Arrays.toString(dataFruit));
            }
            FruitTransaction.Operation operation = operationMap.get(dataFruit[CODE_INDEX]);
            fruitList.add(new FruitTransaction(operation, dataFruit[FRUIT_INDEX],
                    Integer.parseInt(dataFruit[QUANTITY_INDEX])));
        }
        return fruitList;
    }
}
