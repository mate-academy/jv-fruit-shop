package core.basesyntax.service.parse;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitParsed = new ArrayList<>();
        data.stream()
                .skip(1)
                .map(t -> t.split(","))
                .forEach(t -> fruitParsed
                        .add(new FruitTransaction((t[OPERATION]), new Fruit(t[FRUIT]),
                                Integer.parseInt(t[QUANTITY]))));
        return fruitParsed;
    }
}
