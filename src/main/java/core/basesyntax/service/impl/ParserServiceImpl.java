package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserServiceImpl implements ParserService {
    private final int operationIndex = 0;
    private final int fruitNameIndex = 1;
    private final int fruitQuantityIndex = 2;

    @Override
    public List<FruitTransaction> parser(List<String> data) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String string : data) {
            String[] splittedData = string.split(",");
            Optional<FruitTransaction.Operation> operationName =
                    FruitTransaction.Operation.get(splittedData[operationIndex]);
            FruitTransaction fruit = new FruitTransaction(operationName.get(),
                    splittedData[fruitNameIndex],
                    Integer.parseInt(splittedData[fruitQuantityIndex]));
            fruits.add(fruit);
        }
        return fruits;
    }
}
