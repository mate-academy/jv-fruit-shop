package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> parser(List<String> data) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String string : data) {
            String[] splittedData = string.split(",");
            FruitTransaction fruit = new FruitTransaction(FruitTransaction.Operation.valueOf(splittedData[0]),
                    splittedData[1], Integer.parseInt(splittedData[2]));
            fruits.add(fruit);
        }
        return fruits;
    }
}
