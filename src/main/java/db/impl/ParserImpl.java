package db.impl;

import db.Parser;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;

public class ParserImpl implements Parser {
    private static final String HEADER_NAME = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        data.stream()
                .filter(f -> !f.equals(HEADER_NAME))
                .map(f -> f.split(","))
                .forEach(f -> fruitTransactions
                        .add(new FruitTransaction((f[0]), new Fruit(f[1]),
                                Integer.parseInt(f[2]))));
        return fruitTransactions;
    }
}
