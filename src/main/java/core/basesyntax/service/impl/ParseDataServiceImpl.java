package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseDataService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

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
            String fruitName = dataFruit[FRUIT_INDEX];
            if (fruitName.isBlank()) {
                throw new RuntimeException("Fruit name is empty");
            }
            int quantityFruit = Integer.parseInt(dataFruit[QUANTITY_INDEX]);
            if (quantityFruit < 0) {
                throw new RuntimeException("Fruits "
                        + fruitName + " less than 0");
            }
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getByCode(dataFruit[CODE_INDEX]);
            if (!Arrays.stream(FruitTransaction.Operation.values()).toList()
                    .contains(operation)) {
                throw new RuntimeException("Operation isn`t correct: "
                        + operation);
            }
            fruitList.add(new FruitTransaction(operation, dataFruit[FRUIT_INDEX],
                    quantityFruit));
        }
        return fruitList;
    }
}
