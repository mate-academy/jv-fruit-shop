package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
            .skip(1)
            .map(l -> splitLine(l))
            .collect(Collectors.toList());
    }

    private FruitTransaction splitLine(String line) {
        String[] resultLine = line.split(",");
        return new FruitTransaction(
                resultLine[0], new Fruit(resultLine[1]), Integer.parseInt(resultLine[2]));
    }
}
