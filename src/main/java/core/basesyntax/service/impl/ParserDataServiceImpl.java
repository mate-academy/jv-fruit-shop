package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserDataService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserDataServiceImpl implements ParserDataService {
    public List<FruitTransaction> parsedWithFile(List<String> data) {
        return data.stream()
                .skip(1)
                .map(s -> s.replaceAll("\\s+", "").split(","))
                .map(e -> new FruitTransaction(e[0],
                        new Fruit(e[1], Integer.parseInt(e[2]))))
                .collect(Collectors.toList());
    }
}
