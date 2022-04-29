package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;
import service.Parser;

public class ParserImpl implements Parser {
    private static final String HEADER_NAME = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        data.stream()
                .filter(fruitTransaction -> !fruitTransaction.equals(HEADER_NAME))
                .map(fruitTransaction -> fruitTransaction.split(","))
                .forEach(fruitTransaction -> fruitTransactions
                        .add(new FruitTransaction((fruitTransaction[0]),
                                new Fruit(fruitTransaction[1]),
                                Integer.parseInt(fruitTransaction[2]))));
        return fruitTransactions;
    }
}
