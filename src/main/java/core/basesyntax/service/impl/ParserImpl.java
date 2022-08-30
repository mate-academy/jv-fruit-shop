package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaktion;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    @Override
    public List<Transaktion> parse(List<String> lines) {
        return lines.stream()
                .map(s -> s.split(","))
                .map(s -> new Transaktion(s[0], new Fruit(s[1]), Integer.parseInt(s[2])))
                .collect(Collectors.toList());
    }
}
