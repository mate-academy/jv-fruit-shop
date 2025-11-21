package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty!");
        }
        for (int i = 1; i < data.size(); i++) {
            fruitTransactionList.add(parseLine(data.get(i)));
        }
        return fruitTransactionList;
    }

    private FruitTransaction parseLine(String line) {
        String[] split = line.trim().split(",");
        return new FruitTransaction(FruitTransaction.Operation.fromCode(split[0]),
                split[1],
                Integer.parseInt(split[2]));
    }
}
