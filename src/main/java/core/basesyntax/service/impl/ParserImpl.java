package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaktion;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    public static final int INDEX_TRANSACTION = 0;
    public static final int INDEX_FRUIT = 1;
    public static final int INDEX_QUANTITY = 2;

    @Override
    public List<Transaktion> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(s -> s.split(","))
                .map(s -> new Transaktion(s[INDEX_TRANSACTION],
                        new Fruit(s[INDEX_FRUIT]),
                        Integer.parseInt(s[INDEX_QUANTITY])))
                .collect(Collectors.toList());
    }
}
